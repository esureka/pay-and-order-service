package payorder.userservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
class User(
    @field:Id
    val id: Long,

    val name: String,

    val email: String,

    val password: String,

    val userRole: UserRole
)

enum class UserRole {
    CUSTOMER, OWNER, ADMIN
}