package com.api.v2.creditcard.mappers

import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.dtos.CreditCardResponseDto

class CreditCardResponseMapper {

    companion object {
        fun mapToDto(creditCard: CreditCard): CreditCardResponseDto {
            return CreditCardResponseDto(
                creditCard.cardNumber,
                creditCard.flag,
                creditCard.dueDate
            )
        }
    }

}