package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

/**
 * Result of subscription update operation
 */
data class SubscriptionUpdateResult(
    val configCount: Int = 0,      // Total configs updated
    val successCount: Int = 0,     // Subscriptions updated successfully
    val failureCount: Int = 0,     // Subscriptions failed to update
    val skipCount: Int = 0         // Subscriptions skipped (disabled)
) {
    /**
     * Combine two results by adding their counts
     */
    operator fun plus(other: SubscriptionUpdateResult): SubscriptionUpdateResult {
        return SubscriptionUpdateResult(
            configCount = this.configCount + other.configCount,
            successCount = this.successCount + other.successCount,
            failureCount = this.failureCount + other.failureCount,
            skipCount = this.skipCount + other.skipCount
        )
    }
}

