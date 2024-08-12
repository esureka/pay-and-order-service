package payorder.userservice.persistence

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import payorder.userservice.domain.User

interface UserRepository : CoroutineCrudRepository<User, Long> {
}