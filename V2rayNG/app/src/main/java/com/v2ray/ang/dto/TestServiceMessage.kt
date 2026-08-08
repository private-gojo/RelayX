package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import java.io.Serializable

data class TestServiceMessage(
    val key: Int,
    val subscriptionId: String = "",
    val serverGuids: List<String> = emptyList(),
    val onlyTcp: Boolean = false
) : Serializable

