import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":core"))
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}

val resources = "src/org.chiachat.terminus.desktop.main/resources"
compose.desktop {
    application {
        mainClass = "org.chiachat.terminus.desktop.MainKt"
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
