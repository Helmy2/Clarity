package com.example.clarity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clarity.core.ui.components.ClarityButton
import com.example.clarity.core.ui.components.ClarityScaffold
import com.example.clarity.core.ui.components.ClarityTextField
import com.example.clarity.core.ui.theme.ClarityTheme
import com.example.clarity.core.ui.components.ClarityTopAppBar

@Composable
fun AddTaskScreen(
    navController: NavController,
    onAddTask: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val (text, setText) = remember { mutableStateOf("") }

    ClarityScaffold(
        modifier = modifier,
        topBar = { ClarityTopAppBar(title = { Text("Add Task") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(ClarityTheme.spacing.medium)
        ) {
            ClarityTextField(
                value = text,
                onValueChange = setText,
                placeholder = "Enter task title",
                modifier = Modifier.fillMaxWidth()
            )
            ClarityButton(
                onClick = {
                    onAddTask(text)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().padding(top = ClarityTheme.spacing.medium)
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
        AddTaskScreen(navController = rememberNavController(), onAddTask = { })
    }
}

@Preview(name = "AddTaskScreen Dark Mode")
@Composable
fun AddTaskScreenDarkPreview() {
    ClarityTheme(darkTheme = true) {
        AddTaskScreen(navController = rememberNavController(), onAddTask = { })
    }
}
