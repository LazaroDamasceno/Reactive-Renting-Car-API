package com.api.v2.car.services

import com.api.v2.annotations.EmptyFlowException
import com.api.v2.car.domain.CarRepository
import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.car.mappers.CarResponseMapper
import com.api.v2.car.utils.CarFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllCarsRetrievalServiceImpl: AllCarsRetrievalService {

    @Autowired
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var carFinderUtil: CarFinderUtil

    override suspend fun findAll(): Flow<CarResponseDto> {
        return withContext(Dispatchers.IO) {
            if (checkIfFlowIsEmpty()) {
                throw EmptyFlowException()
            }
            carRepository.findAll().map { car -> CarResponseMapper.mapToDto(car) }
        }
    }

    suspend fun checkIfFlowIsEmpty(): Boolean {
        return carRepository.count() == 0L
    }

    override suspend fun findByVin(vin: String): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val existingCar = carFinderUtil.find(vin)
            CarResponseMapper.mapToDto(existingCar)
        }
    }

}