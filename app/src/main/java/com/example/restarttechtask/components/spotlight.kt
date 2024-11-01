package com.example.restarttechtask.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun SpotlightEffect1(targetRect: androidx.compose.ui.geometry.Rect) {
    var targetAlpha by remember { mutableFloatStateOf(0.85f) }
    val animatedAlpha by animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(Unit) {
        while (true) {
            targetAlpha = if (targetAlpha == 0.85f) 0.7f else 0.85f
            delay(1000)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        with(drawContext.canvas.nativeCanvas) {
            val checkPoint = saveLayer(null, null)
            drawRect(color = Color.Black.copy(alpha = 0.8f))

            val maskPaint = Paint().apply {
                color = Color(0f, 0f, 0f, 0f)
                blendMode = BlendMode.Clear
            }

            drawRect(
                targetRect.left,
                targetRect.top,
                targetRect.right,
                targetRect.bottom,
                maskPaint.asFrameworkPaint()
            )

            restoreToCount(checkPoint)
        }
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Preview
@Composable
fun MyScreen2() {
    var showSpotlight by remember { mutableStateOf(true) }
    var buttonRect by remember { mutableStateOf(androidx.compose.ui.geometry.Rect(0f, 0f, 0f, 0f)) }

    Box {
        Card(
            onClick = { showSpotlight = !showSpotlight },
            modifier = Modifier
                .onGloballyPositioned { layoutCoordinates ->
                    val position = layoutCoordinates.positionInRoot()
                    val size = IntSize(layoutCoordinates.size.width, layoutCoordinates.size.height)
                    buttonRect = androidx.compose.ui.geometry.Rect(
                        position.x,
                        position.y,
                        position.x + size.width,
                        position.y + size.height
                    )
                }
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text("Hello Linkedin")
        }

        if (showSpotlight) {
            SpotlightEffect1(targetRect = buttonRect)
        }
    }
}

