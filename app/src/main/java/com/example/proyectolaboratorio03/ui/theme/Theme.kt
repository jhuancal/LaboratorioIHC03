package com.example.proyectolaboratorio03.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = UnsaGreen,
    onPrimary = White,
    primaryContainer = UnsaGreenContainer,
    onPrimaryContainer = UnsaGreenDark,
    secondary = UnsaGold,
    onSecondary = UnsaGreenDark,
    secondaryContainer = UnsaGoldLight,
    onSecondaryContainer = UnsaGoldDark,
    background = UnsaGreenSurface,
    onBackground = Gray900,
    surface = White,
    onSurface = Gray900,
    surfaceVariant = Gray50,
    onSurfaceVariant = Gray600,
    error = UnsaRed,
    onError = White,
    errorContainer = UnsaRedLight,
    onErrorContainer = UnsaRed,
    outline = UnsaGreenBorder,
    outlineVariant = Gray200
)

private val DarkColorScheme = darkColorScheme(
    primary = UnsaGreenLight,
    onPrimary = White,
    primaryContainer = UnsaGreenDark,
    onPrimaryContainer = White,
    secondary = UnsaGold,
    onSecondary = UnsaGreenDark,
    background = Gray900,
    onBackground = White,
    surface = Gray800,
    onSurface = White,
    error = UnsaRed,
    onError = White
)

@Composable
fun ProyectoLaboratorio03Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep brand UNSA colors by default
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = UnsaGreen.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}