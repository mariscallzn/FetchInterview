package com.fetch.feature.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowWidthSizeClass
import com.fetch.core.uisystem.preview.PreviewLightDark
import com.fetch.core.uisystem.theme.FetchTheme
import com.fetch.feature.me.MeScreen
import com.fetch.feature.search.SearchScreen

/**
 * Home screen handle a very basic implementation of two screen for landscape or one for portrait.
 *
 * It defaults to [SearchScreen] if only one screen fits otherwise [SearchScreen] is placed to the right
 * and [MeScreen] to the left sharing a 50\50 of space
 *
 * @param onMeClick call back to indicate that the user has requested navigate to [MeScreen]
 * @param modifier Defaults to [Modifier]
 */
@Composable
fun HomeScreen(
    onMeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    windowSizeClass.windowWidthSizeClass
    if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED) {
        Row(modifier = modifier.fillMaxWidth()) {
            SearchScreen(modifier = Modifier.weight(1f))
            MeScreen(modifier = Modifier.weight(1f))
        }
    } else {
        SearchScreen(
            onMeClick = onMeClick,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewHomeScreen() {
    FetchTheme {
        HomeScreen(onMeClick = {})
    }
}