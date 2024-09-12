package com.api.v2.car.utils

import com.api.v2.car.domain.Car

interface CarFinderUtil {

    suspend fun find(vin: String): Car

}