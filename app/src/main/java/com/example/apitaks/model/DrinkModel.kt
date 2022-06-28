package com.example.apitaks.model

import com.example.Drink
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DrinkModel {
    @SerializedName("drinks")
    var list: MutableList<Drink> = ArrayList()
}