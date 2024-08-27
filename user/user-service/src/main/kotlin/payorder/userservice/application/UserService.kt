package payorder.userservice.application

import payorder.userservice.presentation.dto.request.CreateUserRequest
import payorder.userservice.presentation.dto.response.CreateUserEventRequest
import payorder.userservice.presentation.dto.response.UserDto
import payorder.userservice.presentation.dto.response.UserEventDto

interface UserService {
    suspend fun queryById(id: Long): UserDto
    suspend fun createUser(request: CreateUserRequest)
    suspend fun createUserEvent(request: CreateUserEventRequest)
    suspend fun queryUserEventById(id: String): UserEventDto
}