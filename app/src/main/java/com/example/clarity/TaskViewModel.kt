package com.example.clarity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private var nextTaskId = 1

    fun addTask(title: String) {
        val newTask = Task(nextTaskId++, title, false)
        _tasks.value = _tasks.value + newTask
    }

    fun setTaskCompleted(taskId: Int, isCompleted: Boolean) {
        _tasks.value = _tasks.value.map {
            if (it.id == taskId) {
                it.copy(isCompleted = isCompleted)
            } else {
                it
            }
        }
    }
}
