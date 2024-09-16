package com.api.v2.rent.rent

import com.api.v2.car.domain.Car
import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.car.mappers.CarResponseMapper
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.mappers.CustomerResponseMapper
import com.api.v2.payment.domain.Payment
import com.api.v2.payment.mappers.PaymentResponseMapper

class RentResponseMapper {

    companion object {
        fun map(rent: Rent, customer: Customer, car: Car, payment: Payment): RentResponseDto {
            return RentResponseDto (
                rent.orderNumber,
                CustomerResponseMapper.mapToDto(customer),
                CarResponseMapper.mapToDto(car),
                PaymentResponseMapper.map(payment, payment.creditCard),
                rent.rentedAt
            )
        }
    }

}