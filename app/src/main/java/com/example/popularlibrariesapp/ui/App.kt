package com.example.popularlibrariesapp.ui

import android.app.Application
import com.example.popularlibrariesapp.di.component.DaggerAppComponent
import com.example.popularlibrariesapp.di.modules.ContextModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}