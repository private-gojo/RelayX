package dev.relayx.core.enums
import dev.relayx.core.*
import dev.relayx.core.dto.*
import dev.relayx.core.handler.*
import dev.relayx.core.enums.*
import dev.relayx.core.util.*
import dev.relayx.core.dto.entities.*

enum class NetworkType(val type: String) {
    TCP("tcp"),
    KCP("kcp"),
    WS("ws"),
    HTTP_UPGRADE("httpupgrade"),
    XHTTP("xhttp"),
    HTTP("http"),
    H2("h2"),

    //QUIC("quic"),
    GRPC("grpc"),
    HYSTERIA("hysteria");

    companion object {
        fun fromString(type: String?) = entries.find { it.type == type } ?: TCP
    }
}
