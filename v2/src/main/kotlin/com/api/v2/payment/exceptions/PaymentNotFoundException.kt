package com.api.v2.payment.exceptions

import java.math.BigInteger

class PaymentNotFoundException(orderNumber: BigInteger)
    : RuntimeException("The payment which order is $orderNumber was not found.")