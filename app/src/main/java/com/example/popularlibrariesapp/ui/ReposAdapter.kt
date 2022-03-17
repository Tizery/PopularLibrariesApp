package com.example.popularlibrariesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibrariesapp.databinding.ItemReposBinding
import com.example.popularlibrariesapp.model.GithubRepoModel

class ReposAdapter(
    private val itemClickListener: (GithubRepoModel) -> Unit
) : ListAdapter<GithubRepoModel, ReposAdapter.RepoViewHolder>(GithubRepoItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            ItemReposBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class RepoViewHolder(private val binding: ItemReposBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GithubRepoModel) {
            binding.root.setOnClickListener { itemClickListener(repo) }
            binding.textViewRepoName.text = repo.name
        }
    }
}

object GithubRepoItemCallback : DiffUtil.ItemCallback<GithubRepoModel>() {

    override fun areItemsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem == newItem
    }
}