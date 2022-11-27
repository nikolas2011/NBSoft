package com.example.nbsoft_zadatak.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbsoft_zadatak.R
import com.example.nbsoft_zadatak.adapter.ProductAdapter
import com.example.nbsoft_zadatak.adapter.ProductClickListener
import com.example.nbsoft_zadatak.data.Maybelline
import com.example.nbsoft_zadatak.databinding.FragmentProductDetailsBinding
import com.example.nbsoft_zadatak.databinding.FragmentProductsBinding
import com.example.nbsoft_zadatak.model.Product
import com.example.nbsoft_zadatak.repository.ProductRepo
import com.example.nbsoft_zadatak.viewmodel.ProductViewModel


class ProductsFragment : Fragment(), ProductClickListener {

    private lateinit var binding : FragmentProductsBinding
    private  val  adapter=ProductAdapter(this)
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentProductsBinding.inflate(layoutInflater)

        val api = Maybelline.instance
        val repo = ProductRepo(api)
        val viewModel = ProductViewModel(repo)

        viewModel.getProducts()
        viewModel.products.observe(viewLifecycleOwner){
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
            adapter.loadProducts(it)
        }
        return binding.root
    }

    override fun onProductClick(product: Product) {

        sharedPreferences=context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)!!
        sharedPreferences.edit().apply{
            putString("Name", product.name)
            putString("Brand", product.brand)
            putString("Image", product.image_link)
            putFloat("Price", product.price)

        }.apply()



        findNavController().navigate(R.id.action_productsFragment_to_productDetailsFragment)
    }
}