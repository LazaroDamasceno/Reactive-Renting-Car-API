package com.api.v2.creditcard

import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CreditCardRegistrationServiceImpl: CreditCardRegistrationService {

    @Autowired
    lateinit var creditCardRepository: CreditCardRepository

    override suspend fun register(creditCard: @Valid CreditCard): CreditCardResponseDTO {
        return withContext(Dispatchers.IO) {
            val isThereADuplicatedCardNumber = creditCardRepository
                .findAll()
                .filter { e -> e.cardNumber == creditCard.cardNumber }
                .firstOrNull() != null
            if (isThereADuplicatedCardNumber) {
                throw DuplicatedCardNumberException(creditCard.cardNumber)
            }
            val savedCredit = creditCardRepository.save(creditCard)
            CreditCardResponseMapper.map(savedCredit)
        }
    }

}