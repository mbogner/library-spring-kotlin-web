package dev.mbo.springkotlinweb.webmvc

data class CorsConfigEntry(
    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistry.addMapping
     */
    var mapping: String = "**",

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.allowedOrigins
     */
    var origins: Array<String> = emptyArray(),

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.allowedHeaders
     */
    var headers: Array<String> = emptyArray(),

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.allowedMethods
     */
    var methods: Array<String> = emptyArray(),

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.maxAge
     */
    var maxAge: Long = 1800L,

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.allowCredentials
     */
    var allowCredentials: Boolean = true,

    /**
     * @see org.springframework.web.servlet.config.annotation.CorsRegistration.exposedHeaders
     */
    var exposedHeaders: Array<String> = emptyArray()

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CorsConfigEntry) return false

        if (mapping != other.mapping) return false
        if (!origins.contentEquals(other.origins)) return false
        if (!headers.contentEquals(other.headers)) return false
        if (!methods.contentEquals(other.methods)) return false
        if (maxAge != other.maxAge) return false
        if (allowCredentials != other.allowCredentials) return false
        if (!exposedHeaders.contentEquals(other.exposedHeaders)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = mapping.hashCode()
        result = 31 * result + origins.contentHashCode()
        result = 31 * result + headers.contentHashCode()
        result = 31 * result + methods.contentHashCode()
        result = 31 * result + maxAge.hashCode()
        result = 31 * result + allowCredentials.hashCode()
        result = 31 * result + exposedHeaders.contentHashCode()
        return result
    }
}
