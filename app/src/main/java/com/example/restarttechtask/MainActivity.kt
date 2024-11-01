package com.example.restarttechtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.RestartTechTaskTheme
import com.example.restarttechtask.screens.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestartTechTaskTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun pre(modifier: Modifier = Modifier) {
    RestartTechTaskTheme {
        MainScreen()
    }
}

