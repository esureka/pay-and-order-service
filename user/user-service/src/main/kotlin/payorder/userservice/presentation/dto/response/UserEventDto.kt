package payorder.userservice.presentation.dto.response

import payorder.userservice.domain.EventStatus
import java.time.LocalDateTime

data class UserEventDto(
    val id: String,
    val userId: Long,
    val published: String,
    var publishedAt: LocalDateTime?,
    val createdAt: LocalDateTime,
    val eventStatus: EventStatus
)

data class CreateUserEventRequest(
    val userId: Long,
    val published: String,
    val publishedAt: LocalDateTime?
)
