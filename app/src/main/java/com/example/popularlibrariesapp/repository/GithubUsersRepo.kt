package com.example.popularlibrariesapp.repository

class GithubUsersRepo {
    private val repositories = (1..50).map { GithubUser("login $it") }

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}