package com.api.v2.creditcard.mappers

import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.dtos.CreditCardResponseDto

class CreditCardResponseMapper {

    companion object {
        fun map(creditCard: CreditCard): CreditCardResponseDto {
            return CreditCardResponseDto(
                creditCard.ownerName,
                creditCard.cardNumber,
                creditCard.flag,
                creditCard.cvc,
                creditCard.dueDate,
                creditCard.addedAt
            )
        }
    }

}