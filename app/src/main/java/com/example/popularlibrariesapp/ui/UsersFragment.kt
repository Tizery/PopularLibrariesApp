package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibrariesapp.R
import com.example.popularlibrariesapp.databinding.FragmentUsersBinding
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.presenter.UsersPresenter
import com.example.popularlibrariesapp.ui.image.GlideImageLoader
import com.example.popularlibrariesapp.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    private val binding: FragmentUsersBinding by viewBinding()

    private val presenter: UsersPresenter by moxyPresenter {
        App.instance.initUserSubcomponent()
        App.instance.usersSubcomponent?.provideUsersPresenter()!!
    }

    private val adapter by lazy {
        UsersAdapter(GlideImageLoader(), presenter::onUserClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList(users: List<GithubUserModel>) {
        adapter.submitList(users)
    }


    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val KEY_INIT_PARAMS = "KEY_INIT_PARAMS"
        fun newInstance(): UsersFragment {
            return UsersFragment()
        }
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

}