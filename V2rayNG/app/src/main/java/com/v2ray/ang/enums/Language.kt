package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

enum class Language(val code: String) {
    AUTO("auto"),
    ENGLISH("en"),
    CHINA("zh-rCN"),
    TRADITIONAL_CHINESE("zh-rTW"),
    VIETNAMESE("vi"),
    RUSSIAN("ru"),
    PERSIAN("fa"),
    ARABIC("ar"),
    BANGLA("bn"),
    BAKHTIARI("bqi-rIR");

    companion object {
        fun fromCode(code: String): Language {
            return entries.find { it.code == code } ?: AUTO
        }
    }
}
