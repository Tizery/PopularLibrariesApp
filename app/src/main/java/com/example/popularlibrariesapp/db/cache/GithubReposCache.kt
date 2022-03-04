package com.example.popularlibrariesapp.db.cache

import com.example.popularlibrariesapp.db.dao.ReposDao
import com.example.popularlibrariesapp.db.entity.GithubRepoEntity
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.model.Owner
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubReposCache @Inject constructor(
    private val reposDao: ReposDao
) : IGithubReposCache {

    override fun saveRepos(repos: List<GithubRepoModel>): Single<List<GithubRepoModel>> {
        reposDao.insert(repos.map { GithubRepoEntity(it.id, it.name, it.owner.ownerId) })
        return Single.just(repos)

    }

    override fun getRepos(user : GithubUserModel): Single<List<GithubRepoModel>> {
       return reposDao.getAll(user.id)
           .map { list ->
               list.map { repo -> GithubRepoModel(repo.name, repo.id, Owner(repo.userId)) }
           }
    }



}