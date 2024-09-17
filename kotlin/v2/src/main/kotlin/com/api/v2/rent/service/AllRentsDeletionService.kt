package com.api.v2.rent.service

interface AllRentsDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByOrderNumber(orderNumber: String)

}