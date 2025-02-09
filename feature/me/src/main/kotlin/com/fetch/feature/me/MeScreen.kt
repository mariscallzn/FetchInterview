package com.fetch.feature.me

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * Stateful Me Screen
 */
@Composable
fun MeScreen(
    viewModel: MeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MeScreen(
        uiState = uiState,
        modifier = modifier
    )
}

/**
 * Stateless Me Screen
 */
@Composable
internal fun MeScreen(
    uiState: MeUiState,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = uiState.placeholder)
    }
}