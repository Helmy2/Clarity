
package com.example.clarity.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

@Composable
fun ClarityButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val backgroundColor = if (enabled) ClarityTheme.colors.primary else ClarityTheme.colors.primary.copy(alpha = 0.5f)
    val contentColor = if (enabled) ClarityTheme.colors.onPrimary else ClarityTheme.colors.onPrimary.copy(alpha = 0.5f)

    Surface(
        modifier = modifier
            .clip(ClarityTheme.shapes.medium)
            .clickable(enabled = enabled, onClick = onClick),
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = ClarityTheme.spacing.medium,
                vertical = ClarityTheme.spacing.small
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalTextStyle provides ClarityTheme.typography.button) {
                content()
            }
        }
    }
}


@Preview(name = "Light Mode")
@Composable
fun ClarityButtonLightPreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityButton(onClick = {}, modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Text("ClarityButton")
            }
        }
    }
}

@Preview(name = "Dark Mode")
@Composable
fun ClarityButtonDarkPreview() {
    ClarityTheme(darkTheme = true) {
        Surface(color = ClarityTheme.colors.background) {
            ClarityButton(onClick = {}, modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Text("ClarityButton")
            }
        }
    }
}

@Preview(name = "Disabled")
@Composable
fun ClarityButtonDisabledPreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityButton(enabled = false, onClick = {}, modifier = Modifier.padding(ClarityTheme.spacing.medium)) {
                Text("ClarityButton")
            }
        }
    }
}
