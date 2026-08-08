package dev.relayx.core.dto.entities
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class WebDavConfig(
    val baseUrl: String,
    val username: String? = null,
    val password: String? = null,
    val remoteBasePath: String = "/",
    val timeoutSeconds: Long = 30
)