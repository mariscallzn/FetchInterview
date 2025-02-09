package com.fetch.feature.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fetch.feature.me.MeScreen
import kotlinx.serialization.Serializable

/**
 * Data object that represents the Home navigation type
 */
@Serializable
data object Home

/**
 * Extension function to allow and facilities navigation from consumer modules
 *
 * @param home Route type [Home]. Defaults to [Home]
 * @param navOptions optional [NavOptions]. Defaults to null
 */
fun NavController.navigateToHome(home: Home = Home, navOptions: NavOptions? = null) =
    navigate(route = home, navOptions = navOptions)

/**
 * Extension function to subscribe screen to a navigation graph
 *
 * @param onMeClick call back to indicate that the user has requested navigate to [MeScreen]
 * @param modifier Defaults to [Modifier]
 */
fun NavGraphBuilder.homeScreen(
    onMeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    composable<Home> {
        HomeScreen(
            onMeClick = onMeClick,
            modifier = modifier
        )
    }
}