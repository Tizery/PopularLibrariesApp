package com.example.popularlibrariesapp.di.component

import com.example.popularlibrariesapp.di.modules.RepoModule
import com.example.popularlibrariesapp.di.scope.RepoScope
import com.example.popularlibrariesapp.presenter.ReposPresenterFactory
import dagger.Subcomponent

@Subcomponent(
    modules = [RepoModule::class]
)
@RepoScope
interface RepoSubcomponent {

    fun provideReposPresenterFactory(): ReposPresenterFactory
}