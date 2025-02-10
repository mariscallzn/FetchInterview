package com.fetch.feature.me

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage

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
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current

        SubcomposeAsyncImage(
            model = "https://media.licdn.com/dms/image/v2/D5635AQFv0mBAZ6f7zg/profile-framedphoto-shrink_200_200/profile-framedphoto-shrink_200_200/0/1737650504340?e=1739764800&v=beta&t=XKYPHIHEwPGgBrZhY9BgBeiewJtIZHjQqlZ01qWx0V8",
            contentDescription = "",
            loading = {
                CircularProgressIndicator()
            },
            modifier = Modifier
                .size(240.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.height(32.dp))
        Text("Andres Mariscal Lozano", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        Text(text = buildAnnotatedString {
            val phoneNumber = "+12199299743"
            withLink(
                LinkAnnotation.Clickable(
                    "phoneNumber",
                    TextLinkStyles(style = SpanStyle(color = MaterialTheme.colorScheme.primary))
                ) {
                    Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$phoneNumber")
                        context.startActivity(this)
                    }
                }
            ) {
                append("+1 (219)-929-9743")
            }
        })
        Spacer(Modifier.height(8.dp))
        Text(text = buildAnnotatedString {
            val email = "mariscal.lzn@gmail.com"
            withLink(
                LinkAnnotation.Clickable(
                    "email",
                    TextLinkStyles(style = SpanStyle(color = MaterialTheme.colorScheme.primary))
                ) {
                    Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$email")
                        context.startActivity(this)
                    }
                }) {
                append(email)
            }
        })
    }
}