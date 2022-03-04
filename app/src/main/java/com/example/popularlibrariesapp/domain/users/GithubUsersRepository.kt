package com.example.popularlibrariesapp.domain.users

import com.example.popularlibrariesapp.db.cache.GithubUsersCache
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val usersCache: GithubUsersCache,
    private val networkStatus: NetworkStatus,
) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubApiService.getUsers()
                    .flatMap(usersCache::saveUsers)

            } else {
                usersCache.getUsers()
            }
        }
}


