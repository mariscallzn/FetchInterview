import com.android.build.gradle.LibraryExtension
import com.fetch.buildlogic.androidTestImplementation
import com.fetch.buildlogic.configureKotlinAndroid
import com.fetch.buildlogic.implementation
import com.fetch.buildlogic.libs
import com.fetch.buildlogic.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin that setup a base configuration to be implemented on android libraries
 *
 * The following plugins are applied:
 * - com.android.library
 * - org.jetbrains.kotlin.android
 * - fetch.android.lint [AndroidLintConventionPlugin]
 * - org.jetbrains.kotlin.plugin.serialization
 *
 * It also sets a baseline for kotlin and android [configureKotlinAndroid]
 *
 * Target sdk is set to **35**
 *
 * To avoid collision between libraries, each library is prefixed with the module name, for example
 * ":feature:home" will be named "feature_home_"
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.android")
            apply(plugin = "fetch.android.lint")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 35
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true
                resourcePrefix =
                    path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_")
                        .lowercase() + "_"
            }
            dependencies {
                implementation(libs.findLibrary("kotlinx.serialization.json").get())
                testImplementation(libs.findLibrary("kotlin.test").get())
                testImplementation(libs.findLibrary("kotlinx.coroutines.test").get())
                androidTestImplementation(libs.findLibrary("kotlin.test").get())
            }
        }
    }
}