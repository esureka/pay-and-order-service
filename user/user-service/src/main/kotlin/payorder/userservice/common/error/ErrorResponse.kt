package payorder.userservice.common.error

data class ErrorResponse(
    val errorMessage: String,
    val status: Int
)
