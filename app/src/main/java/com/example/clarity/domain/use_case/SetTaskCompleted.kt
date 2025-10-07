package com.example.clarity.domain.use_case

import com.example.clarity.domain.model.Task
import com.example.clarity.domain.repository.TaskRepository

class SetTaskCompleted(private val repository: TaskRepository) {

    suspend operator fun invoke(task: Task, isCompleted: Boolean) {
        repository.insertTask(task.copy(isCompleted = isCompleted))
    }
}
