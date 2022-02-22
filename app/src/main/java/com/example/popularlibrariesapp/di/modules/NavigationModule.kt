package com.example.popularlibrariesapp.di.modules

import com.example.popularlibrariesapp.ui.screens.AppScreens
import com.example.popularlibrariesapp.ui.screens.IScreens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun providesCicerone() : Cicerone<Router> {
       return Cicerone.create()
    }

    @Provides
    @Singleton
    fun providesRouter(cicerone: Cicerone<Router>) : Router{
        return cicerone.router
    }

    @Provides
    @Singleton
    fun providesNavigatorHolder(cicerone: Cicerone<Router>) : NavigatorHolder{
        return cicerone.getNavigatorHolder()
    }

    @Provides
    @Singleton
    fun providesAppScreens() : IScreens{
        return AppScreens()
    }

}