package com.example.popularlibrariesapp

import com.example.popularlibrariesapp.domain.users.IGithubUsersRepository
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.presenter.UsersPresenter
import com.example.popularlibrariesapp.ui.screens.IScreens
import com.example.popularlibrariesapp.view.UsersView
import com.github.terrakok.cicerone.Cicerone
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class UsersPresenterTest {

    private lateinit var presenter: UsersPresenter

    @Mock
    private lateinit var repository: IGithubUsersRepository

    @Mock
    private lateinit var view: UsersView

    @Mock
    private lateinit var screens: IScreens

    private lateinit var users: List<GithubUserModel>

    @Before
    fun setUp() {

        val cicerone = Cicerone.create()
        val router = cicerone.router

        MockitoAnnotations.initMocks(this)

        presenter = UsersPresenter(router, repository, screens)
    }

    @Test
    fun loadDataSuccessUpdateListTest() {
        presenter.viewState.updateList(users)
        verify(view).updateList(users)
    }

    @Test
    fun loadDataShowErrorTest() {
        val error: Throwable = mock(Throwable::class.java)
        presenter.viewState.showError(error.message)
        verify(view).showError(error.message)
    }
}