package com.example.restarttechtask.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restarttechtask.R
import com.example.restarttechtask.widgets.TabLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainQuestionsScreen(modifier: Modifier = Modifier) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val tabTitles = listOf("Writing1", "Oral")
    val tabIcons = listOf(Icons.Default.Edit, Icons.Rounded.Phone)
    val index = remember { mutableIntStateOf(0) }


    Surface(
        modifier
    ) {
        Column {
            TabLayout(tabTitles, tabIcons) {
                index.intValue = it
            }
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .width(80.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        Color(0xffDDFBFB)
                    ), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text("Filter", modifier = Modifier.padding(5.dp))
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.filterlist),
                    contentDescription = "",
                )

            }
//            FilterComponent()
            when (index.intValue) {
                0 -> WritingQuestionScreen()
                1 -> OralQuestionsScreen()
            }
        }


    }
}
//@Preview
//@Composable
//fun TestTool(modifier: Modifier = Modifier) {
//    TooltipOverLay(MainContent = { MainQuestionsScreen() } , focusedItem = { })
//}