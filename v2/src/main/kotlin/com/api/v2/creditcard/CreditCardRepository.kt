package com.api.v2.creditcard

import org.bson.types.ObjectId
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CreditCardRepository: CoroutineCrudRepository<CreditCard, ObjectId>
