package com.example.popularlibrariesapp.domain.users

import com.example.popularlibrariesapp.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepository {

    fun getUsers() : Single<List<GithubUserModel>>
}