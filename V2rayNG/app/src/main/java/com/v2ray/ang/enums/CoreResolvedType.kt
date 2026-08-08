package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

/** Runtime type used during config assembly only. */
enum class CoreResolvedType {
    NORMAL,
    POLICYGROUP,
    PROXYCHAIN,
}