package com.api.v2.customer.exceptions

class DuplicatedSsnException(ssn: String): Exception("The given SSN $ssn is already registered.")