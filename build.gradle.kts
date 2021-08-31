buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.0.0-alpha4-build328")
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath("com.chaquo.python:gradle:9.1.0")
    }
}

group = "org.chiachat"
version = "1.0"

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.18.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent
    apply(plugin = "io.gitlab.arturbosch.detekt")

    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0")
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }

    detekt {
        buildUponDefaultConfig = true // preconfigure defaults
        allRules = true // activate all available (even unstable) rules.
        // point to your custom config defining rules to run, overwriting default behavior
        config = files("../config/detekt.yml")
        // a way of suppressing issues before introducing detekt
        baseline = file("../config/baseline.xml")

        reports {
            html.enabled = true // observe findings in your browser with structure and code snippets
            xml.enabled = true // checkstyle like format mainly for integrations like Jenkins
            txt.enabled = true
            // similar to the console output, contains issue signature to manually edit baseline files
            sarif.enabled = true
            // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
        }
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        // Target version of the generated JVM bytecode. It is used for type resolution.
        jvmTarget = "1.8"
    }
}
