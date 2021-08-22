plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
}

group = "org.chiachat"
version = "1.0.0"

dependencies {
    api(compose.desktop.currentOs)
    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)
    api(compose.ui)
    api(compose.uiTooling)
    api(compose.preview)
    api("androidx.appcompat:appcompat:1.3.1")
    api("androidx.core:core-ktx:1.6.0")
    api("androidx.activity:activity-compose:1.3.1")

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