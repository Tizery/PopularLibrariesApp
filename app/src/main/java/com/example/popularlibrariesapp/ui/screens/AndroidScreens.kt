package com.example.popularlibrariesapp.ui.screens

import com.example.popularlibrariesapp.repository.GithubUser
import com.example.popularlibrariesapp.ui.UserDetailsFragment
import com.example.popularlibrariesapp.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserDetailsFragment.newInstance(user) }

}