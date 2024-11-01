package com.example.restarttechtask.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipOverLay(
    showTool: Boolean = true,
    focusedItem: @Composable () -> Unit = {},
    MainContent: @Composable () -> Unit = {},
) {

    val showTooltip = remember { mutableStateOf(showTool) }
    val tooltipState = remember { TooltipState() }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background content of the screen
        MainContent()
        if (showTooltip.value) {
            // Semi-transparent overlay on the rest of the screen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )

            // Tooltip target item

            TooltipBoxComposableFun(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                state = tooltipState,
                titleResId = "hello",
                modifier = Modifier,
                focusable = true,
                enableUserInput = false
            ) {
                focusedItem()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipBoxComposableFun(
    positionProvider: PopupPositionProvider,
    titleResId: String,
    state: TooltipState,
    modifier: Modifier = Modifier,
    focusable: Boolean = true,
    enableUserInput: Boolean = true,
    content: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        if (state.isVisible) {
            coroutineScope.launch {
                state.show()
            }
        }
    }
    TooltipBox(
        positionProvider = positionProvider,
        tooltip = {
            RichTooltip(
                title = { Text("this is a text") },
                action = {

                },
                colors = TooltipDefaults.richTooltipColors(
                    containerColor = Color(0xff1F2937),
                    contentColor = Color.White,
                    titleContentColor = Color.White,
                    actionContentColor = Color(0xff1F2937)
                )
            ) {
                Text(titleResId)
            }

        },
        modifier = modifier,
        focusable = focusable,
        state = state
    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .then(if (enableUserInput) Modifier else Modifier.background(Color.Transparent))
        ) {
            content()
        }
    }
}
