package com.example.clarity.core.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClarityTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = ""
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        interactionSource = interactionSource,
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurface
        )
    ) {
        TextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = it,
            enabled = true,
            singleLine = true,
            visualTransformation = androidx.compose.ui.text.input.VisualTransformation.None,
            interactionSource = interactionSource,
            placeholder = { Text(placeholder) },
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                start = 0.dp, end = 0.dp
            )
        )
    }
}

@Preview(name = "Light Mode")
@Composable
fun ClarityTextFieldLightPreview() {
    ClarityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
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
        Surface(color = MaterialTheme.colorScheme.background) {
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
        Surface(color = MaterialTheme.colorScheme.background) {
            ClarityTextField(
                value = "Hello, World!",
                onValueChange = {},
                placeholder = "Type something...",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
