package com.example.nbsoft_zadatak.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbsoft_zadatak.databinding.ProductItemBinding
import com.example.nbsoft_zadatak.model.Product

class ProductViewHolder(private  val binding: ProductItemBinding, private val clickListener: ProductClickListener): RecyclerView.ViewHolder(binding.root) {

    fun bind(product:Product)
    {
        Glide.with(binding.productImageView.context).load(product.image_link).into(binding.productImageView)

        binding.productNametextView.text=product.name
        binding.productBrandtextView2.text=product.brand
        binding.productPricetextView3.text=product.price.toString()

        binding.productCardView.setOnClickListener{
            clickListener.onProductClick(product)
        }
    }

}