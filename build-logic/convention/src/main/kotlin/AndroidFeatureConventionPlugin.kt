import com.fetch.buildlogic.implementation
import com.fetch.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin that setup the based configurations for each feature in the app
 *
 * The following plugins are applied:
 * - fetch.android.library [AndroidLibraryConventionPlugin]
1 * - fetch.hilt [HiltConventionPlugin]
 * - org.jetbrains.kotlin.plugin.serialization
 *
 * [com.fetch.core.uisystem] is added as a common dependency since it contains all the
 * compose libraries defined on its dependencies as **api** so it can be visible to all consumers
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "fetch.android.library")
            apply(plugin = "fetch.hilt")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                implementation(project(":core:uisystem"))
                implementation(project(":core:redux"))
                implementation(libs.findLibrary("androidx.hilt.navigation.compose").get())
                implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
                implementation(libs.findLibrary("androidx.navigation.compose").get())
                implementation(libs.findLibrary("kotlinx.serialization.json").get())
            }
        }
    }
}