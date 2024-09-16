package com.api.v2.rent

interface AllRentsDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByOrderNumber(orderNumber: String)

}