package com.fetch.interview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fetch.core.uisystem.theme.FetchTheme
import com.fetch.feature.home.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchTheme {
                HomeScreen()
            }
        }
    }
}