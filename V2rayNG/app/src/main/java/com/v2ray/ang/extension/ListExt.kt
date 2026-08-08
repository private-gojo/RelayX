package dev.relayx.core.extension
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

/**
 * Moves an item to another index while preserving the relative order of the remaining items.
 */
internal fun <T> MutableList<T>.moveItem(fromIndex: Int, toIndex: Int): Boolean {
    if (fromIndex !in indices || toIndex !in indices || fromIndex == toIndex) return false
    add(toIndex, removeAt(fromIndex))
    return true
}
