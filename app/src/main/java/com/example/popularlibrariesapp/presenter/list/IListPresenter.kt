package com.example.popularlibrariesapp.presenter.list

import com.example.popularlibrariesapp.view.list.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}