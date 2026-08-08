package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

data class CheckUpdateResult(
    val hasUpdate: Boolean,
    val latestVersion: String? = null,
    val releaseNotes: String? = null,
    val downloadUrl: String? = null,
    val error: String? = null,
    val isPreRelease: Boolean = false
)