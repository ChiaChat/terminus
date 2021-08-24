import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "org.chiachat.terminus"
version = "1.0.0"

dependencies {
    api(project(":core"))
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}

val resources = "src/main/resources"
compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Terminus"
            packageVersion = "1.0.0"
            linux {
                iconFile.set(project.file("$resources/icons/snitch.png"))
            }
            macOS {
                iconFile.set(project.file("$resources/icons/snitch.icns"))
            }
            windows {
                iconFile.set(project.file("$resources/icons/snitch.ico"))
            }
        }
    }
}
