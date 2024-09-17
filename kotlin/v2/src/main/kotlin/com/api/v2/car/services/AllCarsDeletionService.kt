package com.api.v2.car.services

interface AllCarsDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByVin(vin: String)

}