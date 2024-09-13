package com.api.v2.payment.exceptions

import java.math.BigInteger

class PaymentNotFoundException(paymentOrder: BigInteger)
    : RuntimeException("The payment which order is $paymentOrder was not found.")