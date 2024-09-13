package com.api.v2.creditcard.services

import com.api.v2.creditcard.domain.CreditCardRepository
import com.api.v2.creditcard.exceptions.EmptyCreditCarEntityException
import com.api.v2.creditcard.utils.CreditCardFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllCreditCarsDeletionServiceImpl: AllCreditCardDeletionService {

    @Autowired
    lateinit var creditCardRepository: CreditCardRepository

    @Autowired
    lateinit var creditCardFinderUtil: CreditCardFinderUtil

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            val isCreditCardEmpty = creditCardRepository
                .findAll()
                .count() == 0
            if (isCreditCardEmpty) throw EmptyCreditCarEntityException()
            creditCardRepository.deleteAll()
        }
    }

    override suspend fun deleteByCardNumber(cardNumber: String) {
        withContext(Dispatchers.IO) {
            val creditCard = creditCardFinderUtil.find(cardNumber)
            creditCardRepository.delete(creditCard)
        }
    }

}