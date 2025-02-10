package com.fetch.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fetch.feature.search.component.HiringGroup

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
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            if (uiState.isFetchingItems) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
            LazyColumn(contentPadding = PaddingValues(bottom = onMeClick?.let { 72.dp }
                ?: 0.dp)) {
                items(uiState.cachedItems) { item ->
                    HiringGroup(item)
                }
            }
        }
        onMeClick?.let {
            Button(
                it,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.feature_search_about_developer))
            }
        }
    }
}