package com.api.v2.rent.exceptions

class RentNotFoundException(orderNumber: String)
    : RuntimeException("Rent which order number is $orderNumber was not found.")