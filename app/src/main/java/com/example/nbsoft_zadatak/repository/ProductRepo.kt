package com.example.nbsoft_zadatak.repository

import com.example.nbsoft_zadatak.data.Maybelline

class ProductRepo(private val maybelline: Maybelline) {

    suspend fun getProducts() = maybelline.getProducts()


}