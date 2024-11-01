package com.example.restarttechtask.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.restarttechtask.components.TaskCard

@Preview
@Composable
fun OralQuestionsScreen(modifier: Modifier = Modifier) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    Surface(modifier) {
        Column {
            LazyColumn(Modifier.fillMaxSize()) {
                items(items = list) {
                    TaskCard()
                }

            }
        }
    }
}