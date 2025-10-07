
package com.example.clarity.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ClarityColors(
    val primary: Color,
    val background: Color,
    val surface: Color,
    val onPrimary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
)

private val LightColors = ClarityColors(
    primary = Blue,
    background = White,
    surface = LightGray,
    onPrimary = White,
    onBackground = Black,
    onSurface = Black,
    onSurfaceVariant = Black.copy(alpha = 0.5f)
)

private val DarkColors = ClarityColors(
    primary = Blue,
    background = Black,
    surface = DarkGray,
    onPrimary = White,
    onBackground = White,
    onSurface = White,
    onSurfaceVariant = White.copy(alpha = 0.5f)
)

private val LocalClarityColors = staticCompositionLocalOf { LightColors }

@Composable
fun ClarityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    CompositionLocalProvider(
        LocalClarityColors provides colors,
        LocalClarityTypography provides typography,
        LocalClarityShapes provides shapes,
        LocalClaritySpacing provides spacing
    ) {
        content()
    }
}

object ClarityTheme {
    val colors: ClarityColors
        @Composable
        @ReadOnlyComposable
        get() = LocalClarityColors.current
    val typography: ClarityTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalClarityTypography.current
    val shapes: ClarityShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalClarityShapes.current
    val spacing: ClaritySpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalClaritySpacing.current
}
