package dev.relayx.core.dto.entities
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class ServersCache(
    val guid: String,
    val profile: ProfileItem,
    val testDelayMillis: Long = 0L,
    val testDelayString: String = "",
)
