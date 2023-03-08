package com.roshka.ejemploretrofit.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.roshka.ejemploretrofit.R
import com.roshka.ejemploretrofit.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        // utilizamos la arquitectura viewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.response.observe(viewLifecycleOwner, Observer { response ->
            binding.message.text = response.toString()
        })

        return binding.root
    }

}