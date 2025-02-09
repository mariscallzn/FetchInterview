package com.fetch.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * Stateful composable
 *
 * @param onMeClick callback to indicate that user is requesting navigate to a Me Screen. Defaults
 *  * to null
 * @param viewModel [SearchViewModel] instance
 * @param modifier defaults to Modifier
 */
@Composable
fun SearchScreen(
    onMeClick: (() -> Unit)? = null,
    viewModel: SearchViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SearchScreen(
        onMeClick = onMeClick,
        uiState = uiState,
        modifier = modifier
    )
}

/**
 * Internal Stateless composable
 *
 * @param onMeClick callback to indicate that user is requesting navigate to a Me Screen. Defaults
 * to null
 * @param uiState [SearchUiState] state flow
 * @param modifier defaults to Modifier
 */
@Composable
internal fun SearchScreen(
    uiState: SearchUiState,
    onMeClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = uiState.placeholder)
    }
}