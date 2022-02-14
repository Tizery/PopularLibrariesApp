package com.example.popularlibrariesapp.domain.users

import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepository(private val githubApiService: GithubApiService) :
    IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApiService.getUsers()
    }
}