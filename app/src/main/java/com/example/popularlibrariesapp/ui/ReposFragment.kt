package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibrariesapp.databinding.FragmentReposBinding
import com.example.popularlibrariesapp.domain.repos.GithubReposRepository
import com.example.popularlibrariesapp.model.GithubRepoModel
import com.example.popularlibrariesapp.presenter.ReposPresenter
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.network.ApiHolder
import com.example.popularlibrariesapp.view.ReposView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(), ReposView, BackButtonListener{

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

    private var _binding: FragmentReposBinding? = null
    private val binding: FragmentReposBinding
        get() = _binding!!

    private val presenter by moxyPresenter {
        ReposPresenter(
            userModel,
            GithubReposRepository(ApiHolder.githubApiService),
            App.instance.router)

    }

    private val adapter by lazy {
        ReposAdapter(presenter::onItemClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


