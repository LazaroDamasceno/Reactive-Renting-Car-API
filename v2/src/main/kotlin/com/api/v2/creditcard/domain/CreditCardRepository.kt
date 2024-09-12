package com.api.v2.creditcard.domain

import org.bson.types.ObjectId
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CreditCardRepository: CoroutineCrudRepository<CreditCard, ObjectId>
