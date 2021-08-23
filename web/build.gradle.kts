import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "org.chiachat.terminus"
version = "1.0"

// Enable JS(IR) target and add dependencies
kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":core"))
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
    }
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().versions.webpackDevServer.version = "4.0.0-rc.0"
}
