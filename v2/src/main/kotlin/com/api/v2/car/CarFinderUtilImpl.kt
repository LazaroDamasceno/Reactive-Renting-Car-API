package com.api.v2.car

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
private class CarFinderUtilImpl: CarFinderUtil {

    @Autowired
    private lateinit var carRepository: CarRepository

    override suspend fun find(vin: String): Car {
        return withContext(Dispatchers.IO) {
            val existingCar = carRepository
                .findAll()
                .filter { e -> e.vin ==  vin }
                .firstOrNull()
            if (existingCar == null) {
                throw CarNotFoundException(vin)
            }
            existingCar
        }

    }

}