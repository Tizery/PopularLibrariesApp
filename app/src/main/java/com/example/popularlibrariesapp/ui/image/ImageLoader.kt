package com.example.popularlibrariesapp.ui.image

interface ImageLoader<T> {

    fun loadInto(url : String, container : T)
}