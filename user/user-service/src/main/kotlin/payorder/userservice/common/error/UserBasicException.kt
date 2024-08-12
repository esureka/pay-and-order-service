package payorder.userservice.common.error

import org.springframework.http.HttpStatus

class UserBasicException(
    val errorMessage: String,
    val status: HttpStatus
) : RuntimeException(errorMessage)