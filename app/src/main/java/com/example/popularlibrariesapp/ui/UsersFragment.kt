package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibrariesapp.databinding.FragmentUsersBinding
import com.example.popularlibrariesapp.presenter.UsersPresenter
import com.example.popularlibrariesapp.repository.GithubUsersRepo
import com.example.popularlibrariesapp.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding
        get() {
            return _binding!!
        }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router
        )
    }
    private var adapter: UsersRecyclerViewAdapter? = null

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun init() {
        with(binding) {
            recyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())
            adapter = UsersRecyclerViewAdapter(presenter.usersListPresenter)
            recyclerViewUsers.adapter = adapter
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        @JvmStatic
        fun newInstance() = UsersFragment()
    }
}