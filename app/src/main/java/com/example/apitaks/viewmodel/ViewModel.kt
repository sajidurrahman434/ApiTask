package com.example.apitaks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.Drink
import com.example.apitaks.repository.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository = Repository()
    private val categoryList: MutableList<String> = ArrayList()
    var query: String = ""

    fun getDrinkList(query: String): MutableLiveData<List<Drink>> {
        return repository.searchDrink(query)
    }
}