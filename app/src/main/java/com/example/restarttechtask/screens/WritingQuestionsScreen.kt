package com.example.restarttechtask.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.restarttechtask.components.VoyageCard

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun WritingQuestionScreen(modifier: Modifier = Modifier) {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    Surface(modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Adjust number of columns
            modifier = Modifier.fillMaxSize(),

            content = {
                items(items = list)
                { item ->
                    VoyageCard(
                    )

                }

            }

        )
    }
}