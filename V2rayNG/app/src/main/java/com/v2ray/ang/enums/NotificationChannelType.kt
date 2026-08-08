package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

/**
 * Enum defining different notification channels.
 * Each channel has a unique channelId, notificationId, and display name.
 */
enum class NotificationChannelType(
    val channelId: String,
    val channelName: String,
    val notificationId: Int
) {
    SUBSCRIPTION_UPDATE(
        channelId = "subscription_update_channel",
        channelName = "Subscription Update Service",
        notificationId = 13
    ),
    CORE_TEST(
        channelId = "core_test_channel",
        channelName = "Core Test Service",
        notificationId = 12
    )
}