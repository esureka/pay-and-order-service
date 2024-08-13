package payorder.orderservice.common.error

import org.springframework.http.HttpStatus

class OrderBasicException(
    val errorMessage: String,
    val status: HttpStatus
): RuntimeException(errorMessage)