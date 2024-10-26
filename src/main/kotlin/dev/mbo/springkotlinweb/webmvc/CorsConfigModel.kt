package dev.mbo.springkotlinweb.webmvc

import dev.mbo.logging.logger
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app.cors")
class CorsConfigModel {

    private val log = logger()

    var allowed: List<CorsConfigEntry> = emptyList()

    @PostConstruct
    fun init() {
        log.info("cors config: {}", this)
    }

    override fun toString(): String {
        return "${javaClass.simpleName}(allowed=$allowed)"
    }
}
