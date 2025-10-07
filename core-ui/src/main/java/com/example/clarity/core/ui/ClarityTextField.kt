
package com.example.clarity.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

@Composable
fun ClarityTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = ""
) {
    Column(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = ClarityTheme.typography.body.copy(
                color = ClarityTheme.colors.onSurface
            ),
            cursorBrush = SolidColor(ClarityTheme.colors.primary)
        ) { innerTextField ->
            Box {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = ClarityTheme.typography.body,
                        color = ClarityTheme.colors.onSurfaceVariant
                    )
                }
                innerTextField()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(ClarityTheme.colors.onSurface.copy(alpha = 0.5f))
        )
    }
}

@Preview(name = "Light Mode")
@Composable
fun ClarityTextFieldLightPreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityTextField(
                value = "",
                onValueChange = {},
                placeholder = "Type something...",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "Dark Mode")
@Composable
fun ClarityTextFieldDarkPreview() {
    ClarityTheme(darkTheme = true) {
        Surface(color = ClarityTheme.colors.background) {
            ClarityTextField(
                value = "",
                onValueChange = {},
                placeholder = "Type something...",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "With Value")
@Composable
fun ClarityTextFieldWithValuePreview() {
    ClarityTheme {
        Surface(color = ClarityTheme.colors.background) {
            ClarityTextField(
                value = "Hello, World!",
                onValueChange = {},
                placeholder = "Type something...",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
