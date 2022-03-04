package com.example.popularlibrariesapp.di.component

import com.example.popularlibrariesapp.di.modules.UserModule
import com.example.popularlibrariesapp.di.scope.UserScope
import com.example.popularlibrariesapp.presenter.UsersPresenter
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UserModule::class,
    ]
)
@UserScope
interface UserSubcomponent {

    fun repoSubcomponent(): RepoSubcomponent

    fun provideUsersPresenter(): UsersPresenter
}