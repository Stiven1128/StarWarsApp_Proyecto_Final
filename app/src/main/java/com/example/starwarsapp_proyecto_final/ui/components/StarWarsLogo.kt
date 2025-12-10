package com.example.starwarsapp_proyecto_final.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarsapp_proyecto_final.R

@Composable
fun StarWarsLogo() {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.scale(scale)
    ) {
        // Estrellas decorativas
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            repeat(5) {
                Text(
                    text = "⭐",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Logo de Star Wars
        Image(
            painter = painterResource(id = R.drawable.star_wars_logo),
            contentDescription = "Star Wars Logo",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(100.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "━━━━━━━━━━━━━━━━",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp
        )
    }
}