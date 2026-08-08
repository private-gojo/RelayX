package dev.relayx.core.ui.base
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

/**
 * Base interface for ViewModel UI events.
 */
interface ViewModelEvent

/**
 * Common UI events for all ViewModels.
 */
interface BaseViewModelEvent : ViewModelEvent {
    object FinishActivity : BaseViewModelEvent
}
