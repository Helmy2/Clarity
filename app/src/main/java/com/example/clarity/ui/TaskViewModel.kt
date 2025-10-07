package com.example.clarity.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clarity.domain.model.Task
import com.example.clarity.domain.use_case.TaskUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        getTasks()
    }

    private fun getTasks() {
        taskUseCases.getTasks()
            .onEach { tasks ->
                _tasks.value = tasks
            }
            .launchIn(viewModelScope)
    }

    fun addTask(title: String) {
        viewModelScope.launch {
            taskUseCases.addTask(Task(title = title, isCompleted = false, id = 0))
        }
    }

    fun setTaskCompleted(task: Task, isCompleted: Boolean) {
        viewModelScope.launch {
            taskUseCases.setTaskCompleted(task, isCompleted)
        }
    }
}
