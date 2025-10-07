package com.example.clarity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clarity.core.ui.components.ClarityButton
import com.example.clarity.core.ui.components.ClarityIcon
import com.example.clarity.core.ui.components.ClarityScaffold
import com.example.clarity.core.ui.components.ClarityText
import com.example.clarity.core.ui.components.ClarityTopAppBar
import com.example.clarity.core.ui.theme.ClarityTheme
import com.example.clarity.domain.model.Task

@Composable
fun TaskListScreen(
    navController: NavController,
    tasks: List<Task>,
    onTaskCompletedChange: (Task, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    ClarityScaffold(
        modifier = modifier,
        topBar = { ClarityTopAppBar(title = { ClarityText("Tasks") }) },
        floatingActionButton = {
            ClarityButton(onClick = { navController.navigate("add_task") }) {
                ClarityIcon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = ClarityTheme.spacing.medium)
        ) {
            items(tasks) { task ->
                TaskItem(
                    title = task.title,
                    isCompleted = task.isCompleted,
                    onCompletedChange = { onTaskCompletedChange(task, it) },
                    modifier = Modifier.padding(vertical = ClarityTheme.spacing.small)
                )
            }
        }
    }
}

@Preview(name = "TaskListScreen Light Mode")
@Composable
fun TaskListScreenLightPreview() {
    ClarityTheme {
        TaskListScreen(navController = rememberNavController(), tasks = emptyList(), onTaskCompletedChange = { _, _ -> })
    }
}

@Preview(name = "TaskListScreen Dark Mode")
@Composable
fun TaskListScreenDarkPreview() {
    ClarityTheme(darkTheme = true) {
        TaskListScreen(navController = rememberNavController(), tasks = emptyList(), onTaskCompletedChange = { _, _ -> })
    }
}
