package com.example.restarttechtask.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.RestartTechTaskTheme

import com.example.restarttechtask.widgets.PreviewHollowCircle

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val list = mutableListOf(true, false, false, false)
    Surface(modifier) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                "Hi UserName",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(Modifier.height(15.dp))
            Text(
                "Study Plan",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                items(list.size)
                { it ->
                    PreviewHollowCircle(item = list[it], it == list.size - 1)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHome(modifier: Modifier = Modifier) {
    RestartTechTaskTheme {
        HomeScreen()
    }
}