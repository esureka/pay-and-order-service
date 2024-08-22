package payorder.userservice.application.port

import payorder.userservice.domain.UserEvent

interface UserEventPort {
    suspend fun findById(id: String): UserEvent?
    suspend fun save(userEvent: UserEvent): UserEvent
}