package com.example.restarttechtask.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.compose.RestartTechTaskTheme


@Composable
fun PreviewHollowCircle(item: Boolean, hideLastPole: Boolean = false) {
    val isCompleted = remember { mutableStateOf(item) }
    MaterialTheme {
        Row() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier.clickable(
                    onClick = {
                        isCompleted.value = !isCompleted.value
                    }
                )) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .border(
                                width = 7.dp,
                                color = if (isCompleted.value) MaterialTheme.colorScheme.primary else Color.LightGray,
                                shape = CircleShape
                            )
                            .size(120.dp)
                    )
                    {
                        Box(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = if (isCompleted.value) MaterialTheme.colorScheme.primary else Color.LightGray,
                                    shape = CircleShape
                                )
                                .size(80.dp)
                                .background(
                                    if (isCompleted.value) MaterialTheme.colorScheme.secondary else Color.LightGray,
                                    shape = CircleShape
                                )
                        )
                    }
                    if (!isCompleted.value) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color =
                                    if (isCompleted.value) MaterialTheme.colorScheme.primary else Color.LightGray,
                                    shape = CircleShape
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "",
                            )
                        }
                    }
                }
                if (!hideLastPole)
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(10.dp)
                            .background(
                                color = if (isCompleted.value) MaterialTheme.colorScheme.primary else Color.LightGray
                            )
                    )

            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Unite1",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "What is examante",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@PreviewLightDark

@Composable
fun pre(modifier: Modifier = Modifier) {
    RestartTechTaskTheme {
        PreviewHollowCircle(true)
    }
}
