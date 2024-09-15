package com.api.v2.payment.services

import com.api.v2.payment.domain.PaymentRepository
import com.api.v2.payment.utils.PaymentFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllPaymentsDeletionServiceImpl: AllPaymentsDeletionService {

    @Autowired
    lateinit var paymentFinderUtil: PaymentFinderUtil

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            paymentRepository.deleteAll()
        }
    }

    override suspend fun deleteByOrderNumber(orderNumber: String) {
        withContext(Dispatchers.IO) {
            val payment = paymentFinderUtil.find(orderNumber)
            paymentRepository.delete(payment)
        }
    }

}