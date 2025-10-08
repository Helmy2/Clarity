package com.example.clarity.di

import androidx.room.Room
import com.example.clarity.data.local.TaskDatabase
import com.example.clarity.data.repository.TaskRepositoryImpl
import com.example.clarity.domain.repository.TaskRepository
import com.example.clarity.domain.use_case.AddTask
import com.example.clarity.domain.use_case.DeleteTask
import com.example.clarity.domain.use_case.GetTasks
import com.example.clarity.domain.use_case.SetTaskCompleted
import com.example.clarity.domain.use_case.TaskUseCases
import com.example.clarity.ui.TaskViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            TaskDatabase::class.java,
            TaskDatabase.DATABASE_NAME
        ).build()
    }
    single { get<TaskDatabase>().taskDao() }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
    single { TaskUseCases(get(), get(), get(), get()) }
    single { AddTask(get()) }
    single { GetTasks(get()) }
    single { SetTaskCompleted(get()) }
    single { DeleteTask(get()) }
    viewModel { TaskViewModel(get()) }
}
