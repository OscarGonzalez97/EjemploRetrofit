package com.roshka.ejemploretrofit.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.roshka.ejemploretrofit.R
import com.roshka.ejemploretrofit.databinding.FragmentMainBinding
import com.roshka.ejemploretrofit.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        // llamamos al objeto de la API y obtenemos los resultados
        Api.retrofitService.getListaRazas().enqueue(object: Callback<String> { // para que lo haga en otro hilo
            override fun onResponse(call: Call<String>, response: Response<String>) {
                binding.message.text = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                binding.message.text = "Failure: " + t.message
            }
        })

        return binding.root
    }

}