package com.example.starwarsapp_proyecto_final.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarsapp_proyecto_final.ui.components.*

@Composable
fun HomeScreen(
    onNavigateToPeople: () -> Unit,
    onNavigateToFilms: () -> Unit,
    onNavigateToPlanets: () -> Unit,
    onNavigateToStarships: () -> Unit,
    onNavigateToVehicles: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo de estrellas animado
        StarfieldBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo animado
            StarWarsLogo()

            Spacer(modifier = Modifier.height(32.dp))

            // Death Star icon
            DeathStarIcon()

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "UNIVERSE EXPLORER",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary,
                letterSpacing = 3.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botones
            StarWarsButton(
                text = "PERSONAJES",
                icon = "👥",
                onClick = onNavigateToPeople,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            StarWarsButton(
                text = "PELÍCULAS",
                icon = "🎬",
                onClick = onNavigateToFilms,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            StarWarsButton(
                text = "PLANETAS",
                icon = "🪐",
                onClick = onNavigateToPlanets,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            StarWarsButton(
                text = "NAVES ESPACIALES",
                icon = "🚀",
                onClick = onNavigateToStarships,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            StarWarsButton(
                text = "VEHÍCULOS",
                icon = "🚗",
                onClick = onNavigateToVehicles,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Que la Fuerza te acompañe",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Elaborado por José Stiven Rodas & Jacobo Galvis",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }
    }
}