plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

group = "org.chiachat"
version = "1.0.0"

dependencies {
    implementation(project(":core"))
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "org.chiachat.kchia.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = version.toString()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}