package com.example.clarity.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: TaskViewModel = koinViewModel()
    val tasks by viewModel.tasks.collectAsState()

    NavHost(navController = navController, startDestination = "task_list") {
        composable("task_list") {
            TaskListScreen(
                navController = navController,
                tasks = tasks,
                onTaskCompletedChange = { task, isCompleted ->
                    viewModel.setTaskCompleted(task, isCompleted)
                }
            )
        }
        composable("add_task") {
            AddTaskScreen(
                navController = navController,
                onAddTask = { title ->
                    viewModel.addTask(title)
                }
            )
        }
    }
}
