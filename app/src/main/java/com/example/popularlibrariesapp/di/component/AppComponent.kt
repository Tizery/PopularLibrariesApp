package com.example.popularlibrariesapp.di.component

import com.example.popularlibrariesapp.MainActivity
import com.example.popularlibrariesapp.di.modules.ContextModule
import com.example.popularlibrariesapp.di.modules.DatabaseModule
import com.example.popularlibrariesapp.di.modules.NavigationModule
import com.example.popularlibrariesapp.di.modules.NetworkModule
import com.example.popularlibrariesapp.presenter.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        DatabaseModule::class,
        NavigationModule::class,
        NetworkModule::class,
    ]
)

@Singleton
interface AppComponent {

    fun providesMainPresenter(): MainPresenter

    fun userSubcomponent(): UserSubcomponent

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

}