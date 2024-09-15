private class AllPaymentsDeletionServiceImpl: AllPaymentsDeletionService {

    @Autowired
    lateinit var paymentFinderUtil: PaymentFinderUtil

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            paymentRepository.deleteAll()
        }
    }

    override suspend fun deleteByOrderNumber(orderNumber: String) {
        withContext(Dispatchers.IO) {
            val payment = paymentFinderUtil.find(orderNumber)
            paymentRepository.delete(payment)
        }
    }

}