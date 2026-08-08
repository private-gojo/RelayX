package dev.relayx.core.dto.entities
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class RulesetItem(
    var id: String = "",
    var remarks: String? = "",
    var ip: List<String>? = null,
    var domain: List<String>? = null,
    var process: List<String>? = null,
    var outboundTag: String = "",
    var port: String? = null,
    var network: String? = null,
    var protocol: List<String>? = null,
    var enabled: Boolean = true,
    var locked: Boolean? = false,
)