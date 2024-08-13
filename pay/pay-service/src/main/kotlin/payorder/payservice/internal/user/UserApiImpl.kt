package payorder.payservice.internal.user

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.util.UriComponentsBuilder
import payorder.payservice.common.error.PayBasicException

@Component
class UserApiImpl(
    private val webClient: WebClient,
    @Value("\${service.user.host}")
    private val userHost: String,
    @Value("\${service.user.port}")
    private val userPort: Int,
    @Value("\${service.scheme}")
    private val scheme: String
) : UserApi {

    override suspend fun queryById(id: Long): User {
        val uri = UriComponentsBuilder.fromPath("/id/{userId}")
            .scheme(scheme)
            .host(userHost)
            .port(userPort)
            .buildAndExpand(id)
            .toUri()

        return webClient.get()
            .uri(uri)
            .retrieve()
            .onStatus({ it.is4xxClientError || it.is5xxServerError }, { throw PayBasicException("User Query API FAILED..", HttpStatus.INTERNAL_SERVER_ERROR) })
            .awaitBody()
    }

}
