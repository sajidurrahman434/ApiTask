package com.example.apitaks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitaks.adapter.DrinksAdapter
import com.example.apitaks.databinding.ActivityMainBinding
import com.example.apitaks.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModel
    lateinit var adapter: DrinksAdapter
    lateinit var query: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory)[ViewModel::class.java]
        viewModel.getDrinkList("").observe(this) {
            adapter = DrinksAdapter(it)
            binding.drinksRecyclerview.adapter = adapter
            binding.drinksRecyclerview.layoutManager = LinearLayoutManager(this)
        }

    }


}