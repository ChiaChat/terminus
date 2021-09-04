plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
}

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
    compileSdk = 31
    defaultConfig {
        applicationId = "org.chiachat.terminus.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = version.toString()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
