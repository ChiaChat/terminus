package org.chiachat.terminus

actual object Platform {
    actual fun getPlatform(): String { return "JVM" }
}