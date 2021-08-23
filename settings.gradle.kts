pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "terminus"

include(":core")
include(":mobile")
include(":android")
include(":desktop")
include(":web")
include(":kchia")
