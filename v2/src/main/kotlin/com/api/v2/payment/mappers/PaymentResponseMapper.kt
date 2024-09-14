package com.api.v2.payment.mappers

import com.api.v2.car.domain.Car
import com.api.v2.car.mappers.CarResponseMapper
import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.mappers.CreditCardResponseMapper
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.mappers.CustomerResponseMapper
import com.api.v2.payment.domain.Payment
import com.api.v2.payment.dtos.PaymentResponseDto
import java.time.ZonedDateTime

class PaymentResponseMapper {

    companion object {
        fun map(customer: Customer, car: Car, creditCard: CreditCard): PaymentResponseDto {
            return PaymentResponseDto(
                CustomerResponseMapper.mapToDto(customer),
                CarResponseMapper.mapToDto(car),
                CreditCardResponseMapper.mapToDto(creditCard),
                ZonedDateTime.now().toString()
            )
        }
    }

}