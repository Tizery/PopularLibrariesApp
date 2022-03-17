package com.example.popularlibrariesapp.ui.screens

import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.ui.ReposFragment
import com.example.popularlibrariesapp.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreens : IScreens {

    override fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    override fun reposScreen(user: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(user)
    }

}