package com.example.apitaks.retrofit

import com.example.apitaks.interfaces.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private var api: ApiInterface? = null
    private var retrofit: Retrofit? = null
    init {
        getRetrofit()
        createApi()
    }
    private fun getRetrofit(): Retrofit? {
        retrofit = Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun createApi(): ApiInterface {
        api = retrofit?.create(ApiInterface::class.java)
        return api!!
    }
}