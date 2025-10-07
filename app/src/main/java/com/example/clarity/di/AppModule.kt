package com.example.clarity.di

import com.example.clarity.ui.TaskViewModel
import com.example.clarity.data.repository.TaskRepositoryImpl
import com.example.clarity.domain.repository.TaskRepository
import com.example.clarity.domain.use_case.AddTask
import com.example.clarity.domain.use_case.GetTasks
import com.example.clarity.domain.use_case.SetTaskCompleted
import com.example.clarity.domain.use_case.TaskUseCases
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::TaskRepositoryImpl).bind<TaskRepository>()
    singleOf(::TaskUseCases)
    singleOf(::AddTask)
    singleOf(::GetTasks)
    singleOf(::SetTaskCompleted)
    viewModelOf(::TaskViewModel)
}
