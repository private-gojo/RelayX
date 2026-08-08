package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class CertSha256Request(
    val address: String = "",
    val port: Int = 443,
    val serverName: String? = null,
    val timeoutMs: Long = 5000L,
)

data class CertSha256Result(
    val sha256: String = "",
    val error: String = "",
)
