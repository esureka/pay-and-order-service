package payorder.payservice.common.error

import org.springframework.boot.autoconfigure.web.WebProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono
import java.net.ConnectException


@Order(-1)
@Component
class GlobalErrorWebExchangeHandler(
    errorAttributes: ErrorAttributes,
    webProperties: WebProperties,
    applicationContext: ApplicationContext,
    serverCodecConfigurer: ServerCodecConfigurer
) : AbstractErrorWebExceptionHandler(
    errorAttributes,
    webProperties.resources,
    applicationContext
) {

    init {
        super.setMessageReaders(serverCodecConfigurer.readers)
        super.setMessageWriters(serverCodecConfigurer.writers)
    }

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.all(), this::handleError)
    }

    private fun handleError(request: ServerRequest): Mono<ServerResponse> =
        when(val throwable = super.getError(request)) {
            is PayBasicException -> buildErrorResponse(throwable)
            is ConnectException -> buildErrorResponse(PayBasicException("Cannot Connect to Service", HttpStatus.INTERNAL_SERVER_ERROR))
            else -> buildErrorResponse(PayBasicException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR))
        }

    private fun buildErrorResponse(ex: PayBasicException) =
        ServerResponse.status(ex.status)
            .bodyValue(
                ErrorResponse(ex.errorMessage, ex.status.value())
            )

}