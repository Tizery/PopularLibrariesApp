package com.example.popularlibrariesapp.ui.screens

import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.ui.ReposFragment
import com.example.popularlibrariesapp.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    fun reposScreen(user: GithubUserModel) = FragmentScreen {
        ReposFragment.newInstance(user)
    }

}