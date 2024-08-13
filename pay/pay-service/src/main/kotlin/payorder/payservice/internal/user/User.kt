package payorder.payservice.internal.user

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val userRole: UserRole
)
