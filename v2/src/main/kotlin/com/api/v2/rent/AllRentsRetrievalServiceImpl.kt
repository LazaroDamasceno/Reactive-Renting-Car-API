package com.api.v2.rent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
private class AllRentsRetrievalServiceImpl: AllRentsRetrievalService {

    @Autowired
    lateinit var rentFinderUtil: RentFinderUtil

    @Autowired
    lateinit var rentRepository: RentRepository

    override suspend fun findByOrderNumber(orderNumber: String): RentResponseDto {
        return withContext(Dispatchers.IO) {
            val existingRent = rentFinderUtil.find(orderNumber)
            RentResponseMapper
                .map(
                    existingRent,
                    existingRent.customer,
                    existingRent.car,
                    existingRent.payment
                )
        }
    }

    override suspend fun findAll(): Flow<RentResponseDto> {
        return withContext(Dispatchers.IO) {
            rentRepository
                .findAll()
                .map{ existingRent -> RentResponseMapper.map(
                    existingRent,
                    existingRent.customer,
                    existingRent.car,
                    existingRent.payment
                ) }
        }
    }

}