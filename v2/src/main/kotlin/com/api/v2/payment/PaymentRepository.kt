package com.api.v2.payment

import org.bson.types.ObjectId
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface PaymentRepository: CoroutineCrudRepository<Payment, ObjectId> {
}