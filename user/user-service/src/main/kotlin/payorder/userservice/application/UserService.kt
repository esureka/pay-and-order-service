package payorder.userservice.application

import payorder.userservice.presentation.dto.request.CreateUserRequest
import payorder.userservice.presentation.dto.response.UserDto

interface UserService {
    suspend fun queryById(id: Long): UserDto
    suspend fun createUser(request: CreateUserRequest)
}