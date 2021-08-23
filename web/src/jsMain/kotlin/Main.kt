import org.chiachat.terminus.Platform
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Text("Hello ${Platform.getPlatform()}")
    }
}
