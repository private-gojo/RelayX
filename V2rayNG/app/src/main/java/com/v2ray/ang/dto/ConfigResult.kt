package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class ConfigResult(
    var status: Boolean,
    var guid: String? = null,
    var content: String = "",
    var errorMessage: String = "",
)

