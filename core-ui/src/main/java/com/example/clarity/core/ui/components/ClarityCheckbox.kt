package com.example.clarity.core.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clarity.core.ui.theme.ClarityTheme

@Composable
fun ClarityCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = CheckboxDefaults.colors(
            checkedColor = ClarityTheme.colors.primary,
            uncheckedColor = ClarityTheme.colors.onSurface.copy(alpha = 0.6f),
            checkmarkColor = ClarityTheme.colors.onPrimary
        )
    )
}

@Preview(name = "Light Mode")
@Composable
private fun ClarityCheckboxLightPreview() {
    ClarityTheme {
        ClarityCheckbox(checked = false, onCheckedChange = {})
    }
}

@Preview(name = "Dark Mode")
@Composable
private fun ClarityCheckboxDarkPreview() {
    ClarityTheme(darkTheme = true) {
        ClarityCheckbox(checked = true, onCheckedChange = {})
    }
}

@Preview(name = "Disabled")
@Composable
private fun ClarityCheckboxDisabledPreview() {
    ClarityTheme {
        ClarityCheckbox(checked = false, onCheckedChange = {}, enabled = false)
    }
}
