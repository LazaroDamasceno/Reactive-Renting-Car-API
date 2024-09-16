package com.api.v2.rent.service

import com.api.v2.car.utils.CarFinderUtil
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.payment.utils.PaymentFinderUtil
import com.api.v2.rent.dtos.RentResponseDto
import com.api.v2.rent.mappers.RentResponseMapper
import com.api.v2.rent.domain.Rent
import com.api.v2.rent.domain.RentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class RentRegistrationServiceImpl: RentRegistrationService {

    @Autowired
    lateinit var rentRepository: RentRepository

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var carFinderUtil: CarFinderUtil

    @Autowired
    lateinit var paymentFinderUtil: PaymentFinderUtil

    override suspend fun register(
        ssn: String,
        vin: String,
        paymentOrderNumber: String
    ): RentResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            val car = carFinderUtil.find(vin)
            val payment = paymentFinderUtil.find(paymentOrderNumber)
            val rent = Rent(customer, car, payment)
            val savedRent = rentRepository.save(rent)
            RentResponseMapper.map(savedRent, customer, car, payment)
        }
    }

}