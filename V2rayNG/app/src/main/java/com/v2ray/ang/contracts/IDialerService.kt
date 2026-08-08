package dev.relayx.core.contracts
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import android.content.Context

interface IDialerService {
    fun start(context: Context, dialerAddr: String)
    fun stop()
}