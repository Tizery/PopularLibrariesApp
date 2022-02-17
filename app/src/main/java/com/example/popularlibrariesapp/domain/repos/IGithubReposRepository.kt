package com.example.popularlibrariesapp.domain.repos

import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubReposRepository {

    fun getRepos(user: GithubUserModel): Single<List<GithubRepoModel>>
}