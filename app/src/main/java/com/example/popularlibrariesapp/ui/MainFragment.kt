package com.example.popularlibrariesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.popularlibrariesapp.presenter.ButtonNumber
import com.example.popularlibrariesapp.presenter.MainPresenter
import com.example.popularlibrariesapp.view.MainView
import com.example.popularlibrariesapp.databinding.FragmentMainBinding

class MainFragment : Fragment(), MainView {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() {
            return _binding!!
        }

    private val presenter = MainPresenter(this)


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            button1.setOnClickListener { presenter.counterClick(ButtonNumber.FIRST) }
            button2.setOnClickListener { presenter.counterClick(ButtonNumber.SECOND) }
            button3.setOnClickListener { presenter.counterClick(ButtonNumber.THIRD) }
        }
    }

    override fun setButton1Text(text: String) {
        binding.button1.text = text
    }

    override fun setButton2Text(text: String) {
        binding.button2.text = text
    }

    override fun setButton3Text(text: String) {
        binding.button3.text = text
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}