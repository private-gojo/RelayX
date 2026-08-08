package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

enum class RoutingType(val fileName: String) {
    WHITE("custom_routing_white"),
    BLACK("custom_routing_black"),
    GLOBAL("custom_routing_global"),
    WHITE_IRAN("custom_routing_white_iran"),
    WHITE_RUSSIA("custom_routing_white_russia")
}
