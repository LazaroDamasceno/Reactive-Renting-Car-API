package com.api.v2.payment.services

interface AllPaymentsDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByOrderNumber(orderNumber: String)

}