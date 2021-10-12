package com.example.mvi_dagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvi_dagger.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val viewModel:RestaurantViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding:ActivityRestaurantBinding=ActivityRestaurantBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val restaurantAdapter=RestaurantAdapter()

        binding.apply {
            recyclerView.apply{
                adapter=restaurantAdapter
                layoutManager=LinearLayoutManager(this@RestaurantActivity)
            }
            viewModel.restaurants.observe(this@RestaurantActivity){
                restaurants -> restaurantAdapter.submitList(restaurants)
            }
        }
    }
}


