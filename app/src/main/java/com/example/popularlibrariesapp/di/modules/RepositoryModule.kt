package com.example.popularlibrariesapp.di.modules

import com.example.popularlibrariesapp.domain.repos.GithubReposRepository
import com.example.popularlibrariesapp.domain.repos.IGithubReposRepository
import com.example.popularlibrariesapp.domain.users.GithubUsersRepository
import com.example.popularlibrariesapp.domain.users.IGithubUsersRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun providesUsersRepository(impl: GithubUsersRepository): IGithubUsersRepository

    @Binds
    @Singleton
    fun providesReposRepository(impl: GithubReposRepository): IGithubReposRepository

}