package com.example.popularlibrariesapp.di.modules

import com.example.popularlibrariesapp.db.dao.ReposDao
import com.example.popularlibrariesapp.db.dao.UserDao
import com.example.popularlibrariesapp.domain.repos.GithubReposRepository
import com.example.popularlibrariesapp.domain.repos.IGithubReposRepository
import com.example.popularlibrariesapp.domain.users.GithubUsersRepository
import com.example.popularlibrariesapp.domain.users.IGithubUsersRepository
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun providesUsersRepository(impl : GithubUsersRepository) : IGithubUsersRepository

    @Binds
    @Singleton
    fun providesReposRepository(impl : GithubReposRepository) : IGithubReposRepository

    /*@Provides
    @Singleton
    fun providesUsersRepo(
        githubApiService: GithubApiService,
        userDao: UserDao,
        networkStatus: NetworkStatus
    ): IGithubUsersRepository {
        return GithubUsersRepository(githubApiService, userDao, networkStatus)
    }

    @Provides
    @Singleton
    fun providesReposRepo(
        githubApiService: GithubApiService,
        reposDao: ReposDao,
        networkStatus: NetworkStatus
    ) : IGithubReposRepository{
        return GithubReposRepository(githubApiService, reposDao, networkStatus)
    }*/

}