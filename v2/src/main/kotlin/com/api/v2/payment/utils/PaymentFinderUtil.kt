package com.api.v2.payment.utils

import com.api.v2.payment.domain.Payment
import com.api.v2.payment.domain.PaymentRepository
import com.api.v2.payment.exceptions.PaymentNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class PaymentFinderUtil {

    @Autowired
    private lateinit var repository: PaymentRepository

    suspend fun find(orderNumber: String): Payment {
        return withContext(Dispatchers.IO) {
            repository
                .findAll()
                .filter { e -> e.orderNumber == BigInteger(orderNumber) }
                .singleOrNull() ?: throw PaymentNotFoundException(BigInteger(orderNumber))
        }
    }

}