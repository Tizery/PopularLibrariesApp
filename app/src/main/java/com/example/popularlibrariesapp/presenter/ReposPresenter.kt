package com.example.popularlibrariesapp.presenter

import android.util.Log
import com.example.popularlibrariesapp.domain.repos.IGithubReposRepository
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.ui.App
import com.example.popularlibrariesapp.view.ReposView
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposPresenter @AssistedInject constructor(
    @Assisted private val userModel: GithubUserModel,
    private val router: Router,
    private val reposRepository: IGithubReposRepository
    ) : MvpPresenter<ReposView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        reposRepository.getRepos(userModel)
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

    override fun onDestroy() {
        super.onDestroy()
        App.instance.destroyRepoScope()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true

    }
}

@AssistedFactory
interface ReposPresenterFactory{
    fun assistedPresenter(userModel: GithubUserModel) : ReposPresenter
}