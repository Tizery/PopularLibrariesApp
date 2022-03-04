package com.example.popularlibrariesapp.db.cache

import com.example.popularlibrariesapp.db.dao.UserDao
import com.example.popularlibrariesapp.db.entity.GithubUserEntity
import com.example.popularlibrariesapp.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersCache @Inject constructor(
    private val userDao: UserDao,
) {

    fun getUsers(): Single<List<GithubUserModel>> {
        return userDao.getAll()
            .map { users ->
                users.map { user ->
                    GithubUserModel(user.id, user.login, user.avatarUrl, user.reposUrl)
                }
            }
    }

    fun saveUsers(users: List<GithubUserModel>): Single<List<GithubUserModel>> {
        userDao.insert(
            users.map { GithubUserEntity(it.id, it.login, it.avatarUrl ?: "", it.reposUrl) }
        )
        return Single.just(users)
    }
}