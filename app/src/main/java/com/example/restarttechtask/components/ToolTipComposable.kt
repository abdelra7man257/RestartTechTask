package com.example.restarttechtask.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipBoxComposable(
    positionProvider: PopupPositionProvider,
    state: TooltipState,
    modifier: Modifier = Modifier,
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
            PlainTooltip(
                content = {
                    content()
                },
                shape = TooltipDefaults.plainTooltipContainerShape,
                containerColor = Color(0xff1F2937),
                contentColor = Color.White,
            )

        },
        modifier = modifier
            .wrapContentSize()
            .padding(20.dp),
        state = state
    ) {
        Box(
            modifier = Modifier
                .then(if (enableUserInput) Modifier else Modifier.background(Color.Transparent))
        ) {
            content()
        }
    }
}







