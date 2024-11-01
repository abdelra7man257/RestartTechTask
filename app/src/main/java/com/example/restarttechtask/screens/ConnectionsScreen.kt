package com.example.restarttechtask.screens

import ProfileCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restarttechtask.widgets.TabLayout

@Preview
@Composable
fun ConnectionsScreen(modifier: Modifier = Modifier) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val listofTabTitles = listOf<String>("Suggestions", "Chat ")

    Surface(modifier = modifier) {
        Column {
            TabLayout(
                tabTitles = listofTabTitles
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Suggested Study Partners :",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = list)
                {
                    ProfileCard()
                }
            }
        }
    }
}