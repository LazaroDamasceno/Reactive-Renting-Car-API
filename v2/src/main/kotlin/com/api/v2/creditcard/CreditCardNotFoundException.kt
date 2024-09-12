package com.api.v2.creditcard

class CreditCardNotFoundException(cardNumber: String)
    : RuntimeException("Credit card which number is $cardNumber was not found.")
