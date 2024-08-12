package payorder.userservice.application

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import payorder.userservice.application.port.UserPort
import payorder.userservice.common.error.UserBasicException
import payorder.userservice.domain.User
import payorder.userservice.presentation.dto.request.CreateUserRequest
import payorder.userservice.presentation.dto.response.UserDto

@Service
class UserServiceImpl(
    private val userPort: UserPort
) : UserService {

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

}