package com.example.clarity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clarity.core.ui.ClarityButton
import com.example.clarity.core.ui.ClarityTextField
import com.example.clarity.core.ui.ClarityTheme
import com.example.clarity.core.ui.ClarityTopAppBar

@Composable
fun AddTaskScreen(modifier: Modifier = Modifier) {
    val (text, setText) = remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            ClarityTopAppBar(title = { Text("Add Task") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            ClarityTextField(
                value = text,
                onValueChange = setText,
                placeholder = "Enter task title",
                modifier = Modifier.fillMaxWidth()
            )
            ClarityButton(
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Text("Save Task")
            }
        }
    }
}

@Preview(name = "AddTaskScreen Light Mode")
@Composable
fun AddTaskScreenLightPreview() {
    ClarityTheme {
        AddTaskScreen()
    }
}

@Preview(name = "AddTaskScreen Dark Mode")
@Composable
fun AddTaskScreenDarkPreview() {
    ClarityTheme(darkTheme = true) {
        AddTaskScreen()
    }
}
