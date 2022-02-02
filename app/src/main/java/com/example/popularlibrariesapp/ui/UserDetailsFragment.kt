package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibrariesapp.databinding.FragmentDetailsUserBinding
import com.example.popularlibrariesapp.presenter.UserDetailsPresenter
import com.example.popularlibrariesapp.repository.GithubUser
import com.example.popularlibrariesapp.view.UserDetailsView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackButtonListener {

    companion object {
        private const val USER_ARGUMENT_KEY = "userArgumentKey"

        fun newInstance(user: GithubUser) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARGUMENT_KEY, user)
            }
        }
    }

    private var _binding: FragmentDetailsUserBinding? = null
    private val binding: FragmentDetailsUserBinding
        get() {
            return _binding!!
        }

    private val userPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARGUMENT_KEY)
        UserDetailsPresenter(user!!, App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun backPressed() = userPresenter.backPressed()

    override fun showUser(login: String) {
        binding.userLogin.text = login
    }
}