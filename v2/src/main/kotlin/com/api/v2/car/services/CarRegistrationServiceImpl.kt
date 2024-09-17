package com.api.v2.car.services

import com.api.v2.car.domain.Car
import com.api.v2.car.domain.CarRepository
import com.api.v2.car.exceptions.DuplicatedVinException
import com.api.v2.car.mappers.CarResponseMapper
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CarRegistrationServiceImpl: CarRegistrationService {

    @Autowired
    lateinit var carRepository: CarRepository

    override suspend fun register(car: @Valid Car) {
        return withContext(Dispatchers.IO) {
            if (checkTheExistenceOfDuplicatedVin(car.vin)) {
                throw DuplicatedVinException(car.vin)
            }
            val savedCar = carRepository.save(car)
            CarResponseMapper.mapToDto(savedCar)
        }
    }

    private suspend fun checkTheExistenceOfDuplicatedVin(vin: String): Boolean {
        return carRepository.findAll().filter { e -> e.vin == vin }.firstOrNull() != null
    }

}