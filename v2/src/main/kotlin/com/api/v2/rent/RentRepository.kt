package com.api.v2.rent

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface RentRepository: CoroutineCrudRepository<Rent, UUID>