package com.api.v2.customer.utils

import com.api.v2.customer.domain.Customer

interface CustomerFinderUtil {

    suspend fun find(ssn: String): Customer

}