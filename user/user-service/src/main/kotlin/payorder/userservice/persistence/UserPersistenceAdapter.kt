package payorder.userservice.persistence

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import payorder.userservice.application.port.UserPort
import payorder.userservice.common.error.UserBasicException
import payorder.userservice.domain.User

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserPort {

    override suspend fun findById(id: Long): User? = userRepository.findById(id)

    override suspend fun save(user: User): User = userRepository.save(user)
}