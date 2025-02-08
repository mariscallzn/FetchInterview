package com.fetch.core.uisystem.preview

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Preview


/**
 * A Wrapper MultiPreview taken from [androidx.compose.ui.tooling.preview.PreviewLightDark]
 * when current rendering only supports APIs up to 33
 *
 * Note that the app theme should support dark and light modes for these previews to be different.
 *
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Preview(name = "Light", apiLevel = 33)
@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL, apiLevel = 33)
annotation class PreviewLightDark