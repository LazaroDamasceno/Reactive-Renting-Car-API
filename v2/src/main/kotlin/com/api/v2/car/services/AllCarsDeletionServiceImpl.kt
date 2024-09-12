package com.api.v2.car.services

import com.api.v2.car.domain.CarRepository
import com.api.v2.car.exceptions.EmptyCarEntityException
import com.api.v2.car.utils.CarFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllCarsDeletionServiceImpl: AllCarsDeletionService {

    @Autowired
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var carFinderUtil: CarFinderUtil

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            if (checkIfCarHasNoElement()) {
                throw EmptyCarEntityException()
            }
            carRepository.deleteAll()
        }
    }

    suspend fun checkIfCarHasNoElement(): Boolean {
        return carRepository.count() == 0L
    }

    override suspend fun deleteByVin(vin: String) {
        withContext(Dispatchers.IO) {
            val existingCar = carFinderUtil.find(vin)
            carRepository.delete(existingCar)
        }
    }

}