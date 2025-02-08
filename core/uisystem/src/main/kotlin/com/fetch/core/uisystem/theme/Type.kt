package com.fetch.core.uisystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.fetch.core.uisystem.R

/**
 * Fetch branded font
 */
val fetchFontFamily = FontFamily(
    Font(R.font.lexend_light, FontWeight.Light),
    Font(R.font.lexend_regular, FontWeight.Normal),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_bold, FontWeight.Bold),
)

/**
 * Default baseline
 */
val baseline = Typography()

/**
 * Modified baseline to apply Fetch font family
 */
val FetchTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = fetchFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = fetchFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = fetchFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = fetchFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = fetchFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = fetchFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = fetchFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = fetchFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = fetchFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = fetchFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = fetchFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = fetchFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = fetchFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = fetchFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = fetchFontFamily),
)

