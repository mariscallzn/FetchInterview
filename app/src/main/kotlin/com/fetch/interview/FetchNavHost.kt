package com.fetch.interview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fetch.feature.home.Home
import com.fetch.feature.home.homeScreen
import com.fetch.feature.me.meScreen
import com.fetch.feature.me.navigateToMeScreen

/**
 * Fetch nav host
 *
 * This nav host manages the following:
 * - [homeScreen]
 * - [meScreen]
 *
 * @param modifier Defaults to [Modifier]
 */
@Composable
fun FetchNavHost(
    modifier: Modifier = Modifier
) {
    val startDestination = Home
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen(onMeClick = { navController.navigateToMeScreen() })
        meScreen()
    }
}