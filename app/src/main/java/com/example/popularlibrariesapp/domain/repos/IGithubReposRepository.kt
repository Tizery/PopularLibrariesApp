package com.example.popularlibrariesapp.domain.repos

import com.example.popularlibrariesapp.model.GithubRepoModel
import io.reactivex.rxjava3.core.Single

interface IGithubReposRepository {

    fun getRepos(reposUrl: String): Single<List<GithubRepoModel>>
}