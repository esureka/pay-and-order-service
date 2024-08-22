package payorder.userservice.persistence

import org.springframework.stereotype.Component
import payorder.userservice.application.port.UserEventPort
import payorder.userservice.domain.UserEvent

@Component
class UserEventPersistenceAdapter(
    private val userEventRepository: UserEventRepository
) : UserEventPort {
    override suspend fun findById(id: String): UserEvent? =
        userEventRepository.findById(id)

    override suspend fun save(userEvent: UserEvent): UserEvent =
        userEventRepository.save(userEvent)

}