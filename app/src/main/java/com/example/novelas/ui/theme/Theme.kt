package com.example.novelmanager.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    primaryContainer = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6)
)

private val AppTypography = Typography()

@Composable
fun NovelManagerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = AppTypography,
        content = content
    )
}
