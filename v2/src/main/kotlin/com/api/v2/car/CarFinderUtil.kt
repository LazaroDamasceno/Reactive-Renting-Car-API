package com.api.v2.car

interface CarFinderUtil {

    suspend fun find(vin: String): Car

}