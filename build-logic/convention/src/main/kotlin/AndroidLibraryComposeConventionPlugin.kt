import com.android.build.gradle.LibraryExtension
import com.fetch.buildlogic.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

/**
 * Convention plugin that setup a based compose configuration
 *
 * The following plugins are applied:
 * - com.android.library
 * - org.jetbrains.kotlin.plugin.compose
 *
 * It defines a baseline for android compose [configureAndroidCompose]
 */
class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}