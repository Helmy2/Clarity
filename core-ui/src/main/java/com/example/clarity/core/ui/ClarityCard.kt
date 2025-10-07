
package com.example.clarity.core.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClarityCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val backgroundColor = if (enabled) ClarityTheme.colors.surface else ClarityTheme.colors.surface.copy(alpha = 0.5f)
    val contentColor = if (enabled) ClarityTheme.colors.onSurface else ClarityTheme.colors.onSurface.copy(alpha = 0.5f)

    Surface(
        modifier = modifier.shadow(elevation = 2.dp, shape = ClarityTheme.shapes.medium),
        shape = ClarityTheme.shapes.medium,
        color = backgroundColor,
        contentColor = contentColor,
        border = BorderStroke(1.dp, ClarityTheme.colors.onSurface.copy(alpha = 0.12f))
    ) {
        content()
    }
}

@Preview(name = "Light Mode")
@Composable
fun ClarityCardLightPreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityCard(modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Column(modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                    Text("This is a ClarityCard")
                }
            }
        }
    }
}

@Preview(name = "Dark Mode")
@Composable
fun ClarityCardDarkPreview() {
    ClarityTheme(darkTheme = true) {
        Surface(color = ClarityTheme.colors.background) {
            ClarityCard(modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Column(modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                    Text("This is a ClarityCard")
                }
            }
        }
    }
}

@Preview(name = "Disabled")
@Composable
fun ClarityCardDisabledPreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityCard(enabled = false, modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Column(modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                    Text("This is a disabled ClarityCard")
                }
            }
        }
    }
}
