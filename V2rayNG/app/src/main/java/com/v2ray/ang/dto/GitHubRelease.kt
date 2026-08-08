package dev.relayx.core.dto
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

import com.google.gson.annotations.SerializedName

data class GitHubRelease(
    @SerializedName("tag_name")
    val tagName: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("assets")
    val assets: List<Asset>,
    @SerializedName("prerelease")
    val prerelease: Boolean = false,
    @SerializedName("published_at")
    val publishedAt: String = ""
) {
    data class Asset(
        @SerializedName("name")
        val name: String,
        @SerializedName("browser_download_url")
        val browserDownloadUrl: String
    )
}