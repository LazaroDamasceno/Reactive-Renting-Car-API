package com.api.v2.rent.utils

import com.api.v2.rent.exceptions.RentNotFoundException
import com.api.v2.rent.domain.Rent
import com.api.v2.rent.domain.RentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class RentFinderUtil {

    @Autowired
    private lateinit var repository: RentRepository

    suspend fun find(orderNumber: String): Rent {
        return withContext(Dispatchers.IO) {
            val existingRent = repository
                .findAll()
                .filter { e -> e.orderNumber == BigInteger(orderNumber) }
                .singleOrNull()
            if (existingRent == null) {
                throw RentNotFoundException(orderNumber)
            }
            existingRent
        }
    }

}