package com.example.popularlibrariesapp.presenter

import com.example.popularlibrariesapp.ui.screens.AppScreens
import com.example.popularlibrariesapp.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AppScreens.usersScreen())
    }

    fun backClicked() {
        router.exit()
    }
}
