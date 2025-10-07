package com.example.clarity

import android.app.Application
import com.example.clarity.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ClarityApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ClarityApp)
            modules(appModule)
        }
    }
}
