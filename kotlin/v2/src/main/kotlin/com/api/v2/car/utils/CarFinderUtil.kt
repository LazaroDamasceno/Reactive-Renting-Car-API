package com.api.v2.car.utils

import com.api.v2.car.exceptions.CarNotFoundException
import com.api.v2.car.domain.Car
import com.api.v2.car.domain.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CarFinderUtil {

    @Autowired
    private lateinit var carRepository: CarRepository

    suspend fun find(vin: String): Car {
        return withContext(Dispatchers.IO) {
            carRepository
                .findAll()
                .filter { e -> e.vin ==  vin }
                .firstOrNull() ?: throw CarNotFoundException(vin)
        }

    }

}