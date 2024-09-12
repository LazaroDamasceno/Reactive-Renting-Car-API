package com.api.v2.creditcard.exceptions

class DuplicatedCardNumberException(cardNumber: String)
    : RuntimeException("Card number $cardNumber was already registered.")