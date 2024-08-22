package payorder.userservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user_event")
class UserEvent(
    @field:Id
    val id: String? = null,

    val userId: Long,

    val published: String,

    var publishedAt: LocalDateTime?,

    val createdAt: LocalDateTime,

    val eventStatus: EventStatus
)

enum class EventStatus {
    CREATED, FAILED, COMPLETED
}