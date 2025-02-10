import com.fetch.buildlogic.configureKotlinJvm
import com.fetch.buildlogic.implementation
import com.fetch.buildlogic.libs
import com.fetch.buildlogic.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.kotlin.jvm")
            apply(plugin = "fetch.android.lint")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            configureKotlinJvm()
            dependencies {
                implementation(libs.findLibrary("kotlinx.serialization.json").get())
                testImplementation(libs.findLibrary("kotlin.test").get())
                testImplementation(libs.findLibrary("kotlinx.coroutines.test").get())
            }
        }
    }
}