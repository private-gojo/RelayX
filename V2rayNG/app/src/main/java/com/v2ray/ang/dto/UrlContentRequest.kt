package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class UrlContentRequest(
    val url: String?,
    val timeout: Int = 15000,
    val httpPort: Int = 0,
    val proxyUsername: String? = null,
    val proxyPassword: String? = null,
    val userAgent: String? = null,
    val requestHeaders: String? = null
)