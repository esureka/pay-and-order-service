package payorder.orderservice.common.filter

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import payorder.orderservice.internal.user.UserRole
import reactor.core.publisher.Mono

@Component
class AuthenticationWebFilter : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request

        val userId = request.headers.getFirst("Request-Member-Id") ?: return chain.filter(exchange)
        val userRole = request.headers.getFirst("Request-Member-Authority")?.let { UserRole.valueOf(it) }
            ?: return chain.filter(exchange)

        val authorities = mutableListOf(SimpleGrantedAuthority("ROLE_${userRole.name}"))

        val userDetails: UserDetails = User(userId, "", authorities)
        val authentication: Authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

        return chain.filter(exchange)
            .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication))
    }
}