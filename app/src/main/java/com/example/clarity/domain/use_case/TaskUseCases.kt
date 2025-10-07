package com.example.clarity.domain.use_case

data class TaskUseCases(
    val getTasks: GetTasks,
    val addTask: AddTask,
    val setTaskCompleted: SetTaskCompleted
)
