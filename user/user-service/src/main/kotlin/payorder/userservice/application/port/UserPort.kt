package payorder.userservice.application.port

import payorder.userservice.domain.User

interface UserPort {
    suspend fun findById(id: Long): User?
    suspend fun save(user: User): User
}