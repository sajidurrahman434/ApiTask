package com.example.apitaks.interfaces

import retrofit2.http.GET
import com.example.apitaks.model.DrinkModel
import retrofit2.Call
import retrofit2.http.Query

interface ApiInterface {
    @GET("search.php?s=margarita")
    fun getDrinkByName(@Query("s") drinkName: String?): Call<DrinkModel?>?
}