package com.example.popularlibrariesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibrariesapp.databinding.ItemUserBinding
import com.example.popularlibrariesapp.presenter.list.UserListPresenter
import com.example.popularlibrariesapp.view.list.IUserItemView

class UsersRecyclerViewAdapter(private val presenter: UserListPresenter) :
    RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolderI>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderI(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolderI, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolderI(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root),
        IUserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(binding) {
            textViewLogin.text = text
        }
    }
}