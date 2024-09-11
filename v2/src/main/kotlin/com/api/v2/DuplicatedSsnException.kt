package com.api.v2

import java.lang.RuntimeException

class DuplicatedSsnException(ssn: String): RuntimeException(
    "The given SSN $ssn is already registered."
)