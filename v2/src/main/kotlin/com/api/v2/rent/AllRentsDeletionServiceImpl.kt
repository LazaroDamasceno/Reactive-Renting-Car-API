package com.api.v2.rent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllRentsDeletionServiceImpl: AllRentsDeletionService {

    @Autowired
    lateinit var rentFinderUtil: RentFinderUtil

    @Autowired
    lateinit var rentRepository: RentRepository

    override suspend fun deleteAll() {
        return withContext(Dispatchers.IO) {
            if (rentRepository.findAll().count() == 0) {
                throw EmptyRentEntityException()
            }
            rentRepository.deleteAll()
        }
    }

    override suspend fun deleteByOrderNumber(orderNumber: String) {
        return withContext(Dispatchers.IO) {
            val existingRent = rentFinderUtil.find(orderNumber)
            rentRepository.delete(existingRent)
        }
    }

}