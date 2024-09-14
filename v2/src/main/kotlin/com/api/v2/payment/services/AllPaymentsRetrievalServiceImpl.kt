package com.api.v2.payment.services

import com.api.v2.payment.domain.PaymentRepository
import com.api.v2.payment.dtos.PaymentResponseDto
import com.api.v2.payment.exceptions.PaymentEntityEmptyException
import com.api.v2.payment.mappers.PaymentResponseMapper
import com.api.v2.payment.utils.PaymentFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllPaymentsRetrievalServiceImpl: AllPaymentsRetrievalService {

    @Autowired
    lateinit var paymentFinderUtil: PaymentFinderUtil

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    override suspend fun findAll(): Flow<PaymentResponseDto> {
        return withContext(Dispatchers.IO) {
            if (paymentRepository.findAll().count() == 0) {
                throw PaymentEntityEmptyException()
            }
            paymentRepository
                .findAll()
                .map { e -> PaymentResponseMapper.map(e, e.customer, e.car, e.creditCard) }
        }

    }

    override suspend fun findByOrderNumber(orderNumber: String): PaymentResponseDto {
        return withContext(Dispatchers.IO) {
            val payment = paymentFinderUtil.find(orderNumber)
            PaymentResponseMapper.map(
                payment,
                payment.customer,
                payment.car,
                payment.creditCard)
        }
    }

}