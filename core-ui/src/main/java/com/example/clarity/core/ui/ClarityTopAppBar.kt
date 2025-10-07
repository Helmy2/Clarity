package com.example.clarity.core.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClarityTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            ProvideTextStyle(value = MaterialTheme.typography.titleLarge) {
                title()
            }
        },
        actions = actions
    )
}

@Preview(name = "Light Mode")
@Composable
fun ClarityTopAppBarLightPreview() {
    ClarityTheme {
        ClarityTopAppBar(title = { Text("Title") })
    }
}

@Preview(name = "Dark Mode")
@Composable
fun ClarityTopAppBarDarkPreview() {
    ClarityTheme(darkTheme = true) {
        ClarityTopAppBar(title = { Text("Title") })
    }
}

@Preview(name = "With Actions")
@Composable
fun ClarityTopAppBarWithActionsPreview() {
    ClarityTheme {
        ClarityTopAppBar(
            title = { Text("Title") },
            actions = {
                ClarityButton(onClick = {}) {
                    Text("Action")
                }
            }
        )
    }
}
