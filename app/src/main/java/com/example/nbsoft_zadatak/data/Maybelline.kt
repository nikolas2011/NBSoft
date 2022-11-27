package com.example.nbsoft_zadatak.data

import com.example.nbsoft_zadatak.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Maybelline {

    @GET("api/v1/products.json?brand=maybelline")
    suspend fun getProducts(): List<Product>


    companion object{
        val instance: Maybelline by lazy {
            val retrofit= Retrofit.Builder()
                .baseUrl("https://makeup-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(Maybelline::class.java)
        }
    }


}