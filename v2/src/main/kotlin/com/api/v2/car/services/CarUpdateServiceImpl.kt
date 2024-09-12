package com.api.v2.car.services

import com.api.v2.car.domain.CarRepository
import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.car.dtos.CarUpdateRequestDto
import com.api.v2.car.mappers.CarResponseMapper
import com.api.v2.car.utils.CarFinderUtil
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CarUpdateServiceImpl: CarUpdateService {

    @Autowired
    private lateinit var carFinderUtil: CarFinderUtil

    @Autowired
    private lateinit var carRepository: CarRepository

    override suspend fun update(vin: String, requestDto: @Valid CarUpdateRequestDto): CarResponseDto {
        return withContext(Dispatchers.IO) {
            val existingCar = carFinderUtil.find(vin)
            existingCar.update(requestDto)
            carRepository.save(existingCar)
            CarResponseMapper.mapToDto(existingCar)
        }
    }

}