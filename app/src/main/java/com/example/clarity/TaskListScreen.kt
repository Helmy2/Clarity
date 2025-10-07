package com.example.clarity

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clarity.core.ui.ClarityButton
import com.example.clarity.core.ui.ClarityTheme
import com.example.clarity.core.ui.ClarityTopAppBar

data class Task(val id: Int, val title: String, var isCompleted: Boolean)

@Composable
fun TaskListScreen(modifier: Modifier = Modifier) {
    val tasks = remember {
        mutableStateListOf(
            Task(1, "Task 1", false),
            Task(2, "Task 2", true),
            Task(3, "Task 3", false)
        )
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            ClarityTopAppBar(title = { Text("Tasks") })
        },
        floatingActionButton = {
            ClarityButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(tasks) { task ->
                TaskItem(
                    title = task.title,
                    isCompleted = task.isCompleted,
                    onCompletedChange = { isCompleted ->
                        val index = tasks.indexOf(task)
                        if (index != -1) {
                            tasks[index] = task.copy(isCompleted = isCompleted)
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Preview(name = "TaskListScreen Light Mode")
@Composable
fun TaskListScreenLightPreview() {
    ClarityTheme {
        TaskListScreen()
    }
}

@Preview(name = "TaskListScreen Dark Mode")
@Composable
fun TaskListScreenDarkPreview() {
    ClarityTheme(darkTheme = true) {
        TaskListScreen()
    }
}
