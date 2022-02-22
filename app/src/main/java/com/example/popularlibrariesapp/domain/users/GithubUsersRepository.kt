package com.example.popularlibrariesapp.domain.users

import com.example.popularlibrariesapp.db.dao.UserDao
import com.example.popularlibrariesapp.db.entity.GithubUserEntity
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.network.GithubApiService
import com.example.popularlibrariesapp.network.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val userDao: UserDao,
    private val networkStatus: NetworkStatus,
) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubApiService.getUsers()
                    .flatMap { users ->
                        userDao.insert(
                            users.map {
                                GithubUserEntity(it.id, it.login, it.avatarUrl ?: "", it.reposUrl)
                            }
                        )
                        Single.just(users)
                    }
            } else {
                userDao.getAll()
                    .map { users ->
                        users.map { user ->
                            GithubUserModel(user.id, user.login, user.avatarUrl, user.reposUrl)
                        }
                    }
            }
        }
}