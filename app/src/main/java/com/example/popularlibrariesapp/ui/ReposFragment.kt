package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibrariesapp.R
import com.example.popularlibrariesapp.databinding.FragmentReposBinding
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.view.ReposView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(R.layout.fragment_repos), ReposView, BackButtonListener {

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(user: GithubUserModel): ReposFragment {
            return ReposFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to user)
            }
        }
    }

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(KEY_USER_MODEL)!!
    }

    private val binding: FragmentReposBinding by viewBinding()

    private val presenter by moxyPresenter {
        App.instance.initRepoSubcomponent()
        App.instance.reposSubcomponent?.provideReposPresenterFactory()
            ?.assistedPresenter(userModel)!!
    }

    private val adapter by lazy {
        ReposAdapter(presenter::onItemClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter
    }

    override fun showRepos(repos: List<GithubRepoModel>?) {
        adapter.submitList(repos)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

}


