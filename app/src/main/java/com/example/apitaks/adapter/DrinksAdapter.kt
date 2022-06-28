package com.example.apitaks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Drink
import com.example.apitaks.R
import de.hdodenhof.circleimageview.CircleImageView

class DrinksAdapter(private val drinkList: List<Drink> = ArrayList()) :
    RecyclerView.Adapter<DrinksAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val drinkThumb: CircleImageView = itemView.findViewById(R.id.thumb)
        val title: AppCompatTextView = itemView.findViewById(R.id.drinkTitle)
        val desc: AppCompatTextView = itemView.findViewById(R.id.drinkDesc)
        val check: CheckBox = itemView.findViewById(R.id.categortyCheck)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.drink_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView).load(drinkList[position].strDrinkThumb).into(holder.drinkThumb)
        holder.title.text = drinkList[position].strDrink
        holder.desc.text = drinkList[position].strInstructions
        if (drinkList[position].strAlcoholic == "Alcoholic")
            holder.check.isChecked = true
    }

    override fun getItemCount(): Int = drinkList.size
}