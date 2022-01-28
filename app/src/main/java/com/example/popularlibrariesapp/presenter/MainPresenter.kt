package com.example.popularlibrariesapp.presenter

import com.example.popularlibrariesapp.view.MainView
import com.example.popularlibrariesapp.model.CountersModel

class MainPresenter(val view: MainView) {
    private val model = CountersModel()

    fun counterClick(button: ButtonNumber) {
        when (button) {
            ButtonNumber.FIRST -> {
                val nextValue = model.next(0)
                view.setButton1Text("$nextValue")
            }
            ButtonNumber.SECOND -> {
                val nextValue = model.next(1)
                view.setButton2Text("$nextValue")
            }
            ButtonNumber.THIRD -> {
                val nextValue = model.next(2)
                view.setButton3Text("$nextValue")
            }
        }
    }
}
