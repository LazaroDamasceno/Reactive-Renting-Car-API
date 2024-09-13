package com.api.v2.payment

import java.math.BigInteger

class PaymentNotFoundException(paymentOrder: BigInteger)
    : RuntimeException("The payment which order is $paymentOrder was not found.")