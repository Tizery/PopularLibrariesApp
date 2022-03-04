package com.example.popularlibrariesapp.db.cache

import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubReposCache {

    fun saveRepos(repos: List<GithubRepoModel>): Single<List<GithubRepoModel>>
    fun getRepos(user : GithubUserModel): Single<List<GithubRepoModel>>

}