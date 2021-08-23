plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
}

group = "org.chiachat"
version = "1.0.0"

dependencies {
    implementation(project(":core"))
    implementation(compose.desktop.currentOs)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.ui)
    implementation(compose.uiTooling)
    implementation(compose.preview)
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "org.chiachat.terminus.android"
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
