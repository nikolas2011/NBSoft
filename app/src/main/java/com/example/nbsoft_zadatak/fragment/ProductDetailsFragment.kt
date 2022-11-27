package com.example.nbsoft_zadatak.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nbsoft_zadatak.R
import com.example.nbsoft_zadatak.databinding.FragmentProductDetailsBinding


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProductDetailsBinding.inflate(layoutInflater)

        sharedPreferences=context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)!!

        val name= sharedPreferences.getString("Name", "")
        val brand=sharedPreferences.getString("Brand", "")
        val image=sharedPreferences.getString("Image", "")
        val price=sharedPreferences.getFloat("Price", 0f)

        binding.BrandtextView.text=brand
        binding.NametextView1.text=name
        Glide.with(binding.ProdcutimageView.context).load(image).into(binding.ProdcutimageView)
        binding.PricetextView3.text=price.toString()

        return binding.root
    }

}