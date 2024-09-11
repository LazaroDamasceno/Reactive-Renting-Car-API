package com.api.v2.customer.services

interface AllCustomersDeletionService {

    suspend fun deleteBySsn(ssn: String)
    suspend fun deleteAll()

}