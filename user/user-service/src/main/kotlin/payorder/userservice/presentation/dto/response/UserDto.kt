package payorder.userservice.presentation.dto.response

import payorder.userservice.domain.UserRole

data class UserDto(
    val id: Long,
    val name: String,
    val email: String,
    val userRole: UserRole
)

data class UserIdAndRole(
    val id: Long,
    val userRole: UserRole
)