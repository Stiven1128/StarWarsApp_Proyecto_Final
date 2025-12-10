package com.example.starwarsapp_proyecto_final.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun StarfieldBackground() {
    val stars = remember {
        List(100) {
            Star(
                x = Random.nextFloat(),
                y = Random.nextFloat(),
                size = Random.nextFloat() * 3f + 1f,
                speed = Random.nextFloat() * 2f + 0.5f
            )
        }
    }

    var time by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            withFrameMillis {
                time += 0.016f
            }
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        stars.forEach { star ->
            val alpha = ((kotlin.math.sin(time * star.speed) + 1f) / 2f) * 0.8f + 0.2f
            drawCircle(
                color = Color.White.copy(alpha = alpha),
                radius = star.size,
                center = Offset(
                    x = size.width * star.x,
                    y = size.height * star.y
                )
            )
        }
    }
}

data class Star(
    val x: Float,
    val y: Float,
    val size: Float,
    val speed: Float
)