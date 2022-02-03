package com.example.popularlibrariesapp.presenter

import com.example.popularlibrariesapp.repository.GithubUser
import com.example.popularlibrariesapp.view.UserDetailsView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserDetailsPresenter(val user: GithubUser, val router: Router) :
    MvpPresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showUser(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}