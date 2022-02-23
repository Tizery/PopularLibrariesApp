package com.example.popularlibrariesapp.ui

import android.app.Application
import com.example.popularlibrariesapp.di.component.DaggerAppComponent
import com.example.popularlibrariesapp.di.component.RepoSubcomponent
import com.example.popularlibrariesapp.di.component.UserSubcomponent
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

    var usersSubcomponent: UserSubcomponent? = null
        private set
    var reposSubcomponent: RepoSubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun initUserSubcomponent(): UserSubcomponent {
        usersSubcomponent = appComponent.userSubcomponent()
        return usersSubcomponent!!
    }

    fun initRepoSubcomponent(): RepoSubcomponent {
        reposSubcomponent = appComponent.userSubcomponent().repoSubcomponent()
        return reposSubcomponent!!
    }

    fun destroyRepoScope() {
        reposSubcomponent = null
    }

    fun destroyUserScope() {
        usersSubcomponent = null
    }
}