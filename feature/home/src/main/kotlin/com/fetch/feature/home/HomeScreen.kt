package com.fetch.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fetch.core.uisystem.preview.PreviewLightDark
import com.fetch.core.uisystem.theme.FetchTheme

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Hello, World")
    }
}

@PreviewLightDark
@Composable
private fun PreviewHomeScreen() {
    FetchTheme {
        HomeScreen()
    }
}