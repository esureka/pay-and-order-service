package payorder.payservice.internal.user

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserUtil {

    suspend fun getCurrentMemberId(): Long =
        ReactiveSecurityContextHolder.getContext().awaitSingle().authentication.name.toLong()

    fun getCurrentMemberIdMono(): Mono<Long> =
        ReactiveSecurityContextHolder.getContext().map { it.authentication.name.toLong() }
}