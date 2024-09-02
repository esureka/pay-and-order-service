package payorder.userservice.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import payorder.userservice.application.UserService
import payorder.userservice.presentation.dto.request.CreateUserRequest
import payorder.userservice.presentation.dto.response.CreateUserEventRequest
import payorder.userservice.presentation.dto.response.UserDto
import payorder.userservice.presentation.dto.response.UserEventDto

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun queryUserById(@PathVariable id: Long): UserDto {
        return userService.queryById(id)
    }

    @PostMapping
    suspend fun createUser(@RequestBody request: CreateUserRequest) {
        userService.createUser(request)
    }

    @PostMapping("/event")
    suspend fun createUserEvent(@RequestBody request: CreateUserEventRequest) {
        userService.createUserEvent(request)
    }

    @GetMapping("/event/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun queryUserEventById(@PathVariable id: String): UserEventDto {
        return userService.queryUserEventById(id)
    }

}
