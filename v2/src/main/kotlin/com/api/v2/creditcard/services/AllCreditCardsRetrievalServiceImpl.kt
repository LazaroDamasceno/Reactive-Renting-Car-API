package com.api.v2.creditcard.services;

import com.api.v2.annotations.EmptyFlowException
import com.api.v2.creditcard.domain.CreditCardRepository
import com.api.v2.creditcard.dtos.CreditCardResponseDto
import com.api.v2.creditcard.mappers.CreditCardResponseMapper
import com.api.v2.creditcard.utils.CreditCardFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;

@Service
private class AllCreditCardsRetrievalServiceImpl: AllCreditCardsRetrievalService {

    @Autowired
    lateinit var creditCardFinderUtil: CreditCardFinderUtil

    @Autowired
    lateinit var creditCardRepository: CreditCardRepository

    override suspend  fun findByCardNumber(cardNumber: String): CreditCardResponseDto {
        return withContext(Dispatchers.IO) {
            val creditCard = creditCardFinderUtil.find(cardNumber)
            CreditCardResponseMapper.map(creditCard)
        }
    }

    override suspend  fun findAll(): Flow<CreditCardResponseDto> {
        return withContext(Dispatchers.IO) {
            if (creditCardRepository.findAll().count() == 0) {
                throw EmptyFlowException()
            }
            creditCardRepository.findAll().map { e -> CreditCardResponseMapper.map(e) }
        }
    }

}
