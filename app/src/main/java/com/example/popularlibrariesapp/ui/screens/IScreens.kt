package com.example.popularlibrariesapp.ui.screens

import com.example.popularlibrariesapp.model.GithubUserModel
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface IScreens {

    fun usersScreen() : FragmentScreen

    fun reposScreen(user : GithubUserModel) : FragmentScreen

}