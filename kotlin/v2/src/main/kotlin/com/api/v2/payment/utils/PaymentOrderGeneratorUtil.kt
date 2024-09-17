package com.api.v2.payment.utils

import java.math.BigInteger
import java.time.ZonedDateTime

class PaymentOrderGeneratorUtil {

    companion object {
        fun generate(): BigInteger {
            val year = ZonedDateTime.now().year
            val format = "${year}0000"
            var orderNumber = BigInteger(format)
            orderNumber = orderNumber.plus(BigInteger.ONE)
            return orderNumber
        }
    }

}