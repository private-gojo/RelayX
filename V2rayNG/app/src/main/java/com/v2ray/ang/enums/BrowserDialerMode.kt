package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

enum class BrowserDialerMode(val value: String) {
    OKHTTP("OkHttp"),
    WEBVIEW("WebView");

    companion object {
        fun from(value: String?): BrowserDialerMode? = entries.find { it.value == value }
    }
}
