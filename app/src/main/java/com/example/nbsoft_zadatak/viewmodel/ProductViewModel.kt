package com.example.nbsoft_zadatak.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbsoft_zadatak.model.Product
import com.example.nbsoft_zadatak.repository.ProductRepo
import kotlinx.coroutines.launch

class ProductViewModel(private  val repo: ProductRepo): ViewModel() {

    val products: MutableLiveData<List<Product>> = MutableLiveData()

    fun getProducts() {
        viewModelScope.launch {
            val result = repo.getProducts()
            products.value=result

        }
    }

}