package com.example.popularlibrariesapp.di.modules

import com.example.popularlibrariesapp.db.cache.GithubUsersCache
import com.example.popularlibrariesapp.di.scope.UserScope
import com.example.popularlibrariesapp.domain.users.GithubUsersRepository
import com.example.popularlibrariesapp.domain.users.IGithubUsersRepository
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    @UserScope
    fun provideUserRepository(
        apiService: GithubApiService,
        usersCache: GithubUsersCache,
        networkStatus: NetworkStatus
    ): IGithubUsersRepository {
        return GithubUsersRepository(apiService, usersCache, networkStatus)
    }
}