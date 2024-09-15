interface AllPaymentsDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByOrderNumber(orderNumber: String)

}