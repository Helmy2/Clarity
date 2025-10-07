package com.example.clarity.data.repository

import com.example.clarity.domain.model.Task
import com.example.clarity.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TaskRepositoryImpl : TaskRepository {

    private val tasks = MutableStateFlow<List<Task>>(emptyList())
    private var nextTaskId = 1

    override fun getTasks(): Flow<List<Task>> {
        return tasks
    }

    override suspend fun getTaskById(id: Int): Task? {
        return tasks.value.find { it.id == id }
    }

    override suspend fun insertTask(task: Task) {
        tasks.value = tasks.value + task.copy(id = nextTaskId++)
    }

    override suspend fun deleteTask(task: Task) {
        tasks.value = tasks.value - task
    }
}
