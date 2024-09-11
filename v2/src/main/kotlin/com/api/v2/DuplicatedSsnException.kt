package com.api.v2

class DuplicatedSsnException(ssn: String): Exception("The given SSN $ssn is already registered.")