package com.example.popularlibrariesapp.presenter

import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.domain.users.IGithubUsersRepository
import com.example.popularlibrariesapp.ui.screens.AppScreens
import com.example.popularlibrariesapp.view.UsersView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepository: IGithubUsersRepository,
    private val router: Router
) :
    MvpPresenter<UsersView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { users ->
                    viewState.updateList(users)
                },
                { error ->
                    viewState.showError(error.message)
                }
            )
    }

    fun onUserClicked(githubUserModel: GithubUserModel) {
        router.navigateTo(AppScreens.reposScreen(githubUserModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
