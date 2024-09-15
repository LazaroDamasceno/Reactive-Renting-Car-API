@RequestMapping("api/v2/payments")
@RestController
class AllPaymentsDeletionController {

    @Autowired
    private lateinit service: AllPaymentsDeletionService

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    suspend fun deleteAll() {
        return service.deleteAll()
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("{orderNumber}")
    suspend fun deleteByOrderNumber(@PathVariable orderNumber: String) {
        return service.deleteByOrderNumber(orderNumber)
    }

}