package org.chiachat.terminus.mobile


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
