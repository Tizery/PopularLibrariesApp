package com.example.popularlibrariesapp.presenter

import android.util.Log
import com.example.popularlibrariesapp.domain.repos.IGithubReposRepository
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.view.ReposView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposPresenter(
    private val userModel: GithubUserModel,
    private val reposRepository: IGithubReposRepository,
    private val router: Router,
) : MvpPresenter<ReposView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        reposRepository.getRepos(userModel.reposUrl)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repos ->
                    viewState.showRepos(repos)
                },
                {
                    Log.e("Repos", "Error getting repos", it)
                }
            )

    }

    fun onItemClicked(repo: GithubRepoModel) {

    }

    fun backPressed(): Boolean {
        router.exit()
        return true

    }
}