package com.example.clarity.core.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
    val cardColors = if (enabled) {
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    } else {
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
        )
    }

    Card(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)),
        colors = cardColors
    ) {
        content()
    }
}

@Preview(name = "Light Mode")
@Composable
fun ClarityCardLightPreview() {
    ClarityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityCard(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
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
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityCard(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
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
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityCard(enabled = false, modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("This is a disabled ClarityCard")
                }
            }
        }
    }
}
