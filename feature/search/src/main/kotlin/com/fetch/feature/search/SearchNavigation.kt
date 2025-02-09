package com.fetch.feature.search

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

/**
 * Data object that represents the Search navigation type
 */
@Serializable
data object Search

/**
 * Extension function to allow and facilities navigation from consumer modules
 *
 * @param search Route type [Search]. Defaults to [Search].
 * @param navOptions optional [NavOptions]. Defaults to null.
 */
fun NavController.navigateToSearchScreen(search: Search = Search, navOptions: NavOptions? = null) =
    navigate(
        route = search,
        navOptions = navOptions
    )

/**
 * Extension function to subscribe screen to a navigation graph
 *
 * @param modifier Defaults to [Modifier]
 */
fun NavGraphBuilder.searchScreen(
    modifier: Modifier = Modifier
) {
    composable<Search> {
        SearchScreen(
            modifier = modifier
        )
    }
}