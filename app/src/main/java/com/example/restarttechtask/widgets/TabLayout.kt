package com.example.restarttechtask.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TabLayout(
    tabTitles: List<String>? = null,
    listOfIcons: List<ImageVector>? = null,
    onClick: @Composable (index: Int) -> Unit = {}
) {
    var selectedTabIndex = remember { mutableStateOf(0) }

    Column {

        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.fillMaxWidth(),
            contentColor = Color.White,
        ) {
            tabTitles?.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = { selectedTabIndex.value = index },
                    text = { Text(text = title, color = MaterialTheme.colorScheme.primary) },
                    icon = {
                        listOfIcons?.let {
                            Icon(
                                imageVector = it[index],
                                contentDescription = title,
                                tint = if (selectedTabIndex.value == index) MaterialTheme.colorScheme.primary else Color.LightGray
                            )

                        }
                    })
                onClick(selectedTabIndex.value)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


