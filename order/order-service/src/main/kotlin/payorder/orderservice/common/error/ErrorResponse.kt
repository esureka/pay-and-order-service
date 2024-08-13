package payorder.orderservice.common.error

data class ErrorResponse(
    val errorMessage: String,
    val status: Int
)
