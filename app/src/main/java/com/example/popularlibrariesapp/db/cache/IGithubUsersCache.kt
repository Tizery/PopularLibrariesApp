package com.example.popularlibrariesapp.db.cache

import com.example.popularlibrariesapp.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubUsersCache {

    fun getUsers(): Single<List<GithubUserModel>>
    fun saveUsers(users: List<GithubUserModel>): Single<List<GithubUserModel>>

}