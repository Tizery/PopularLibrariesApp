package com.example.popularlibrariesapp.domain.repos

import com.example.popularlibrariesapp.db.cache.GithubReposCache
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubReposRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val reposCache: GithubReposCache,
    private val networkStatus: NetworkStatus
) : IGithubReposRepository {

    override fun getRepos(user: GithubUserModel): Single<List<GithubRepoModel>> =
        networkStatus.isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    githubApiService.getRepos(user.reposUrl)
                        .flatMap(reposCache::saveRepos)
                } else {
                    reposCache.getRepos(user)
                }
            }
}
