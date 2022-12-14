package com.example.mvi_dagger.api

import com.example.mvi_dagger.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {
    companion object{
        const val BASE_URL="https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurant():List<Restaurant>
}