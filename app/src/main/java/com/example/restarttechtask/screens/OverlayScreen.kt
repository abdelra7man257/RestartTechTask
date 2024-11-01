package com.example.restarttechtask.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun OverlayScreen(content: @Composable () -> Unit = {}) {
    var isVisible = rememberSaveable { mutableStateOf(true) }
    Box {
        content()
        if (isVisible.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.70f))
                    .clickable(onClick = {
                        isVisible.value = false
                    }),
                contentAlignment = Alignment.Companion.Center
            ) {
                // Content inside the overlay
                Column(horizontalAlignment = Alignment.Companion.CenterHorizontally) {
                    Text(
                        text = "Tap anywhere on the screen to continue",
                        color = Color.Companion.White,
                        textAlign = TextAlign.Companion.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

    }
}
