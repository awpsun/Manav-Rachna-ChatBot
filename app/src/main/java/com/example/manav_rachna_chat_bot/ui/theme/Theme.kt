package com.example.manav_rachna_chat_bot.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = MRURed,
    secondary = MRUBlue,
    tertiary = MRULightBlue,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = MRUWhite,
    onSecondary = MRUWhite,
    onBackground = MRUWhite,
    onSurface = MRUWhite
)

private val LightColorScheme = lightColorScheme(
    primary = MRURed,
    secondary = MRUBlue,
    tertiary = MRULightBlue,
    background = MRUGrey,
    surface = MRUWhite,
    onPrimary = MRUWhite,
    onSecondary = MRUWhite,
    onBackground = MRUDarkGrey,
    onSurface = MRUDarkGrey,
    primaryContainer = MRURed,
    onPrimaryContainer = MRUWhite,
    secondaryContainer = MRUBlue,
    onSecondaryContainer = MRUWhite
)

@Composable
fun ManavRachnaChatBotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
