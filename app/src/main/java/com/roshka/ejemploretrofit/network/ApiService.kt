package com.roshka.ejemploretrofit.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/"

private val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create()) // agregamos el conversor
            .baseUrl(BASE_URL) // agregamos la url Base de nuestro service
            .build() // creamos el objeto retrofit

// creamos la interfaz para que retrofit pueda hablar con nuestro web service usando HTTP
interface ApiService {
    @GET("breeds/list/all") // especificamos el endpoint especifico
    fun getListaRazas(): Call<String> // nos crea un objeto Call, que se utiliza para usar el request
    @GET("solicitudes") // especificamos el endpoint especifico
    fun getSolicitudes(): Call<String> // nos crea un objeto Call, que se utiliza para usar el request
}

// ya que consume mucho y solo necesitamos una instancia de la API podemos crear un objeto publico para usarlo en todas partes
object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}