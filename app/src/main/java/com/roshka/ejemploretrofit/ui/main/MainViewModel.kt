package com.roshka.ejemploretrofit.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roshka.ejemploretrofit.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getRazas()
    }

    private fun getRazas() {
        // llamamos al objeto de la API y obtenemos los resultados
        Api.retrofitService.getListaRazas().enqueue(object: Callback<String>{ // para que lo haga en otro hilo
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }
        })

        _response.value = "xd"
    }

}