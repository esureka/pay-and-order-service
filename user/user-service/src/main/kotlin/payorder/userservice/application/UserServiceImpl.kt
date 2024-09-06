package payorder.userservice.application

import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import payorder.userservice.application.port.UserEventPort
import payorder.userservice.application.port.UserPort
import payorder.userservice.common.error.UserBasicException
import payorder.userservice.domain.EventStatus
import payorder.userservice.domain.User
import payorder.userservice.domain.UserEvent
import payorder.userservice.presentation.dto.request.CreateUserRequest
import payorder.userservice.presentation.dto.response.CreateUserEventRequest
import payorder.userservice.presentation.dto.response.UserDto
import payorder.userservice.presentation.dto.response.UserEventDto
import java.time.LocalDateTime

@Service
class UserServiceImpl(
    private val userPort: UserPort,
    private val userEventPort: UserEventPort
) : UserService {

    @Transactional(readOnly = true)
    override suspend fun queryById(id: Long): UserDto {
        val user = userPort.findById(id)
            ?: throw UserBasicException("User Not Found..", HttpStatus.NOT_FOUND)

        return UserDto(
            id = user.id,
            name = user.name,
            email = user.email,
            userRole = user.userRole
        )
    }

    override suspend fun createUser(request: CreateUserRequest) {
        userPort.save(
            User(
                name = request.name,
                email = request.email,
                userRole = request.userRole
            )
        )
    }

    override suspend fun createUserEvent(request: CreateUserEventRequest) {
        userEventPort.save(
            UserEvent(
                userId = request.userId,
                published = request.published,
                publishedAt = request.publishedAt,
                createdAt = LocalDateTime.now(),
                eventStatus = EventStatus.CREATED
            )
        )
    }

    override suspend fun queryUserEventById(id: String): UserEventDto {
        val event = userEventPort.findById(id)
            ?: throw UserBasicException("Not Found User Event $id", HttpStatus.NOT_FOUND)

        return UserEventDto(
            id = event.id!!,
            userId = event.userId,
            published = event.published,
            publishedAt = event.publishedAt,
            createdAt = event.createdAt,
            eventStatus = event.eventStatus
        )
    }

}