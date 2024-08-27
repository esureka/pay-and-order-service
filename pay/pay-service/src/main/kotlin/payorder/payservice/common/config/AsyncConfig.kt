package payorder.payservice.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
@EnableAsync
class AsyncConfig{

    val threadPoolNotificationEvent = 8

    @Bean(name = ["notificationEventHandler"])
    fun emailEventHandlerTaskExecutor(): ExecutorService {
        return Executors.newFixedThreadPool(threadPoolNotificationEvent)
    }
}