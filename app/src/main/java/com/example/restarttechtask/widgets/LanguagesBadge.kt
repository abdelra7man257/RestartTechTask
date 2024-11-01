package com.example.restarttechtask.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LanguageBadges(languages: List<String>) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        languages.forEach { language ->
            Box(
                modifier = Modifier
                    .background(Color(0xFFB2DFDB), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = language,
                    color = Color(0xFF004D40),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}