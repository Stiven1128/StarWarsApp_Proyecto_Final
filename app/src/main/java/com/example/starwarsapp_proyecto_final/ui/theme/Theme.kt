package com.example.starwarsapp_proyecto_final.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val StarWarsDarkColorScheme = darkColorScheme(
    primary = StarWarsYellow,
    onPrimary = StarWarsBlack,
    primaryContainer = StarWarsLightGray,
    onPrimaryContainer = StarWarsYellow,

    secondary = LightSideBlue,
    onSecondary = StarWarsBlack,
    secondaryContainer = StarWarsLightGray,
    onSecondaryContainer = LightSideCyan,

    tertiary = DarkSideRed,
    onTertiary = StarWarsWhite,

    background = BackgroundDark,
    onBackground = TextSecondary,

    surface = BackgroundCard,
    onSurface = TextSecondary,
    surfaceVariant = BackgroundCardLight,
    onSurfaceVariant = TextTertiary,

    error = DarkSideRed,
    onError = StarWarsWhite
)

@Composable
fun StarWarsApp_Proyecto_FinalTheme(
    darkTheme: Boolean = true, // Siempre tema oscuro para Star Wars
    content: @Composable () -> Unit
) {
    val colorScheme = StarWarsDarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}