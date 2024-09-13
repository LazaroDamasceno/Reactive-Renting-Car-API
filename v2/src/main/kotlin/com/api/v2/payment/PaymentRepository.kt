package com.api.v2.payment

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PaymentRepository: CoroutineCrudRepository<Payment, UUID>