package com.api.v2.creditcard.utils

import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.domain.CreditCardRepository
import com.api.v2.creditcard.exceptions.CreditCardNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CreditCardFinderUtil {

    @Autowired
    lateinit var creditCardRepository: CreditCardRepository

    suspend fun find(cardNumber: String): CreditCard {
        return withContext(Dispatchers.IO) {
            val foundedCreditCard = creditCardRepository
                .findAll()
                .filter { e -> e.cardNumber == cardNumber }
                .firstOrNull();
            if (foundedCreditCard == null) throw CreditCardNotFoundException(cardNumber)
            foundedCreditCard
        }
    }

}