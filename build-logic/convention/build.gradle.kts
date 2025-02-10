import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    alias(libs.plugins.android.lint)
}

group = "com.fetch.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    lintChecks(libs.androidx.lint.gradle)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidLint") {
            id = libs.plugins.fetch.android.lint.get().pluginId
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.fetch.jvm.library.get().pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.fetch.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.fetch.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.fetch.android.library.asProvider().get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.fetch.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.fetch.android.feature.get().pluginId
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.fetch.hilt.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }
        register("androidRoom") {
            id = libs.plugins.fetch.android.room.get().pluginId
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}