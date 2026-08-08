package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

sealed class RealPingEvent {

    /** Periodic progress update while the batch is still running. */
    data class Progress(val text: String) : RealPingEvent()

    /** A single server result is available. */
    data class Result(val guid: String, val delayMillis: Long) : RealPingEvent()

    /** The entire batch has finished or been cancelled. */
    data class Finish(val status: String) : RealPingEvent()
}

