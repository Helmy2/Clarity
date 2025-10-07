package com.example.clarity.domain.use_case

import com.example.clarity.domain.model.Task
import com.example.clarity.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasks(private val repository: TaskRepository) {

    operator fun invoke(): Flow<List<Task>> {
        return repository.getTasks()
    }
}
