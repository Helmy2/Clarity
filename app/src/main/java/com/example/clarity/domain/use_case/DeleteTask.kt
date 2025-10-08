package com.example.clarity.domain.use_case

import com.example.clarity.domain.model.Task
import com.example.clarity.domain.repository.TaskRepository

class DeleteTask(private val repository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}
