package com.example.popularlibrariesapp.di.modules

import com.example.popularlibrariesapp.db.cache.GithubReposCache
import com.example.popularlibrariesapp.di.scope.RepoScope
import com.example.popularlibrariesapp.domain.repos.GithubReposRepository
import com.example.popularlibrariesapp.domain.repos.IGithubReposRepository
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    @RepoScope
    fun provideRepoRepository(
        apiService: GithubApiService,
        reposCache: GithubReposCache,
        networkStatus: NetworkStatus
    ): IGithubReposRepository {
        return GithubReposRepository(apiService, reposCache, networkStatus)
    }
}