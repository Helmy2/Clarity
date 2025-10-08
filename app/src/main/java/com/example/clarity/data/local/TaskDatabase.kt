package com.example.clarity.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clarity.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "task_db"
    }
}
