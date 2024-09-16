package com.api.v2.rent.rent

import java.math.BigInteger
import java.time.ZonedDateTime

class RentOrderNumberGeneratorUtil {

    companion object {
        fun generate(): BigInteger {
            val year = ZonedDateTime.now().year
            val format = BigInteger("${year}0000")
            var number = format
            number = number.plus(BigInteger.ONE)
            return number
        }
    }

}