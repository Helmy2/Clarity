package com.example.clarity.core.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClarityButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
        )
    ) {
        content()
    }
}

@Preview(name = "Light Mode")
@Composable
fun ClarityButtonLightPreview() {
    ClarityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityButton(onClick = {}, modifier = Modifier.padding(16.dp)) {
                Text("ClarityButton")
            }
        }
    }
}

@Preview(name = "Dark Mode")
@Composable
fun ClarityButtonDarkPreview() {
    ClarityTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityButton(onClick = {}, modifier = Modifier.padding(16.dp)) {
                Text("ClarityButton")
            }
        }
    }
}

@Preview(name = "Disabled")
@Composable
fun ClarityButtonDisabledPreview() {
    ClarityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityButton(enabled = false, onClick = {}, modifier = Modifier.padding(16.dp)) {
                Text("ClarityButton")
            }
        }
    }
}
