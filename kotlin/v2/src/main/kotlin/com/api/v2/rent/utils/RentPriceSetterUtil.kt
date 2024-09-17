package com.api.v2.rent.utils

import java.math.BigDecimal

class RentPriceSetterUtil {

    companion object {
        fun setPrice(days: Long): BigDecimal {
            val pricePerDay = 65.0
            return BigDecimal(days * pricePerDay)
        }
    }

}