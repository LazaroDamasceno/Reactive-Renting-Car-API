package com.api.v2.payment.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PaymentRepository: CoroutineCrudRepository<Payment, UUID>