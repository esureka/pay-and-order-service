package payorder.userservice.persistence

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import payorder.userservice.domain.UserEvent

interface UserEventRepository : CoroutineCrudRepository<UserEvent, String> {
}