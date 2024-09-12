package com.api.v2.creditcard

class CreditCardResponseMapper {

    companion object {
        fun map(creditCard: CreditCard): CreditCardResponseDTO {
            return CreditCardResponseDTO(
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