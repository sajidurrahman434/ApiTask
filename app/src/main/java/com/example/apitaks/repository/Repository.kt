package com.example.apitaks.repository

import androidx.lifecycle.MutableLiveData
import com.example.Drink
import com.example.apitaks.model.DrinkModel
import com.example.apitaks.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private var drinkList: MutableLiveData<List<Drink>> = MutableLiveData()
    private var apiClient: ApiClient = ApiClient()

    private val drinkListResponse = object : Callback<DrinkModel?> {
        override fun onResponse(call: Call<DrinkModel?>, response: Response<DrinkModel?>) {
            if (response.isSuccessful) {
                updateDrinkList(response.body()?.list)
            }
        }

        override fun onFailure(call: Call<DrinkModel?>, t: Throwable) {
            t.printStackTrace()
        }


    }

    private fun updateDrinkList(drinkList: MutableList<Drink>?) {

        if (!drinkList.isNullOrEmpty()) {
            this.drinkList.postValue(drinkList)
        } else {
            this.drinkList.postValue(ArrayList())
        }
    }

    fun searchDrink(name: String): MutableLiveData<List<Drink>> {
        apiClient.createApi().getDrinkByName(name)?.enqueue(drinkListResponse)
        return drinkList
    }
}