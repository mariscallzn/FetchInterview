package com.fetch.feature.me

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

/**
 * Data object that represents the Me navigation type
 */
@Serializable
data object Me

/**
 * Extension function to allow and facilities navigation from consumer modules
 *
 * @param me Route type [Me]. Defaults to [Me].
 * @param navOptions optional [NavOptions]. Defaults to null.
 */
fun NavController.navigateToMeScreen(me: Me = Me, navOptions: NavOptions? = null) =
    navigate(route = me, navOptions = navOptions)

/**
 * Extension function to subscribe screen to a navigation graph
 *
 * @param modifier Defaults to [Modifier]
 */
fun NavGraphBuilder.meScreen(
    modifier: Modifier = Modifier
) {
    composable<Me> {
        MeScreen(
            modifier = modifier
        )
    }
}