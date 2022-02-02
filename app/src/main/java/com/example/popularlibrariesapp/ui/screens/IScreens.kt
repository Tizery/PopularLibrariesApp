package com.example.popularlibrariesapp.ui.screens

import com.example.popularlibrariesapp.repository.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}