package payorder.payservice.common.error

import org.springframework.http.HttpStatus

class PayBasicException(
    val errorMessage: String,
    val status: HttpStatus
) : RuntimeException(errorMessage)