package com.api.v2.rent.exceptions

class TerminatedRentException(orderNumber: String)
    : RuntimeException("Rent which order number is $orderNumber is terminated.")