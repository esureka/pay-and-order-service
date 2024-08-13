package payorder.payservice.common.error

data class ErrorResponse(
    val errorMessage: String,
    val status: Int
)
