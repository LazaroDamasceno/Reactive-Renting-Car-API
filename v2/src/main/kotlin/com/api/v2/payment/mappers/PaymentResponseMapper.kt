package com.api.v2.payment.mappers

import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.mappers.CreditCardResponseMapper
import com.api.v2.payment.domain.Payment
import com.api.v2.payment.dtos.PaymentResponseDto

class PaymentResponseMapper {

    companion object {
        fun map(payment: Payment, creditCard: CreditCard): PaymentResponseDto {
            return PaymentResponseDto(
                payment.orderNumber,
                CreditCardResponseMapper.mapToDto(creditCard),
                payment.paidAt
            )
        }
    }

}