package com.api.v2

class CustomerNotFoundException: RuntimeException("Customer was not found.") {
}