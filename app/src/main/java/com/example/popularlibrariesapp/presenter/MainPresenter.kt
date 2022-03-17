package com.example.popularlibrariesapp.presenter

import com.example.popularlibrariesapp.ui.screens.IScreens
import com.example.popularlibrariesapp.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.usersScreen())
    }

    fun backClicked() {
        router.exit()
    }
}
