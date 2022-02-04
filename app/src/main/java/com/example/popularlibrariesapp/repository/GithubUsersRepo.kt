package com.example.popularlibrariesapp.repository

import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): Observable<List<GithubUser>> = Observable.just(repositories)
}