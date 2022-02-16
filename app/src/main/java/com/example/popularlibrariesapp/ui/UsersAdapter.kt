package com.example.popularlibrariesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibrariesapp.databinding.ItemUserBinding
import com.example.popularlibrariesapp.model.GithubUserModel
import com.example.popularlibrariesapp.ui.image.ImageLoader

class UsersAdapter(
    private val imageLoader: ImageLoader<ImageView>,
    private val itemClickListener: (GithubUserModel) -> Unit,
) : ListAdapter<GithubUserModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showUser(githubUserModel: GithubUserModel) {
            binding.root.setOnClickListener { itemClickListener(githubUserModel) }
            binding.textViewLogin.text = githubUserModel.login
            if (githubUserModel.avatarUrl != null) {
                imageLoader.loadInto(githubUserModel.avatarUrl, binding.avatarImageView)
            }
        }
    }

        object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUserModel>() {
            override fun areItemsTheSame(
                oldItem: GithubUserModel,
                newItem: GithubUserModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GithubUserModel,
                newItem: GithubUserModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
