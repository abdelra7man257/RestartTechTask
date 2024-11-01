package com.example.restarttechtask.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.restarttechtask.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterComponent() {
    var showSpotlight by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val tooltipState = remember { TooltipState(isPersistent = true) }

    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(80.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable {
                showSpotlight = !showSpotlight
                scope.launch {
                    tooltipState.show()
                }
            }
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

}