package com.api.v2.rent.service

import com.api.v2.rent.domain.RentRepository
import com.api.v2.rent.exceptions.TerminatedRentException
import com.api.v2.rent.utils.RentFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class RentTerminationServiceImpl: RentTerminationService {

    @Autowired
    lateinit var rentFinderUtil: RentFinderUtil

    @Autowired
    lateinit var rentRepository: RentRepository

    override suspend fun terminate(orderNumber: String) {
        return withContext(Dispatchers.IO) {
            val existingRent = rentFinderUtil.find(orderNumber)
            if (existingRent.returnedAt.isNotEmpty()) {
                throw TerminatedRentException(orderNumber)
            }
            val terminatedRent = existingRent.markAsReturned()
            rentRepository.save(terminatedRent)
        }
    }

}