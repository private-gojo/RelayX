package dev.relayx.core.fmt
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import dev.relayx.core.AppConfig
import dev.relayx.core.dto.V2rayNShareItem
import dev.relayx.core.dto.entities.ProfileItem
import dev.relayx.core.util.JsonUtil
import dev.relayx.core.util.LogUtil
import dev.relayx.core.util.Utils

object V2rayNFmt : FmtBase() {
    fun parse(str: String): ProfileItem? {
        try {
            val jsonBase64Payload = str.substringAfterLast('/')
            val jsonPayload = Utils.decode(jsonBase64Payload)
            val v2rayNShareItem = JsonUtil.fromJson(jsonPayload, V2rayNShareItem::class.java)
            return v2rayNShareItem?.toProfileItem()
        } catch (e: Exception) {
            LogUtil.e(AppConfig.TAG, "Failed to parse V2rayN format", e)
        }
        return null
    }
}