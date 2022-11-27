package com.example.nbsoft_zadatak.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbsoft_zadatak.databinding.ProductItemBinding
import com.example.nbsoft_zadatak.model.Product

class ProductAdapter(private val productClickListener: ProductClickListener) : RecyclerView.Adapter<ProductViewHolder>() {

    private var products = emptyList<Product>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            return ProductViewHolder(
                binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            , clickListener = productClickListener
            )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

       holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun loadProducts(products: List<Product>){
        this.products=products
    }
}
interface ProductClickListener{
    fun onProductClick(product: Product)
}