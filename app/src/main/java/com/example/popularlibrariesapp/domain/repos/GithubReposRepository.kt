package com.example.popularlibrariesapp.domain.repos

import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubReposRepository(private val githubApiService: GithubApiService) : IGithubReposRepository {

    override fun getRepos(reposUrl: String): Single<List<GithubRepoModel>> {
        return githubApiService.getRepos(reposUrl)
    }
}
