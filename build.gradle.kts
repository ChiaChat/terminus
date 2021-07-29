buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:4.2.0")
    }
}

group = "com.abysl"
version = "1.0"

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}