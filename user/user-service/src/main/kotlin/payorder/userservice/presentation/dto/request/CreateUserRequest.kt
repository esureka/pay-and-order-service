package payorder.userservice.presentation.dto.request

import payorder.userservice.domain.UserRole

data class CreateUserRequest(
    val name: String,
    val email: String,
    val userRole: UserRole
)
