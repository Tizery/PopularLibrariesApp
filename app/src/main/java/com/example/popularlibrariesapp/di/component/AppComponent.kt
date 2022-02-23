package com.example.popularlibrariesapp.di.component

import com.example.popularlibrariesapp.MainActivity
import com.example.popularlibrariesapp.di.modules.*
import com.example.popularlibrariesapp.presenter.MainPresenter
import com.example.popularlibrariesapp.presenter.ReposPresenter
import com.example.popularlibrariesapp.presenter.ReposPresenterFactory
import com.example.popularlibrariesapp.presenter.UsersPresenter
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

    fun providesMainPresenter() : MainPresenter

    fun userSubcomponent(): UserSubcomponent

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

}