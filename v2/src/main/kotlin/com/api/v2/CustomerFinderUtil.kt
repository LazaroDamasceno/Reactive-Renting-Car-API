package com.api.v2

interface CustomerFinderUtil {

    suspend fun find(ssn: String): Customer

}