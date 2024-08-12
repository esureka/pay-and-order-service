package payorder.userservice.common

import org.springframework.http.HttpStatus

class UserBasicException(
    val errorMessage: String,
    val status: HttpStatus
) : RuntimeException(errorMessage)