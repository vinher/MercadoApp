package com.skytex.mercadoapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skytex.mercadoapp.R
import com.skytex.mercadoapp.domain.model.Product
import com.skytex.mercadoapp.ui.listeners.ListenerProducts
import com.squareup.picasso.Picasso

class ProductsAdapter (
    private var elementos:List<Product>,
    //private val listener: ListenerProducts
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
    )

    override fun getItemCount(): Int = elementos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(elementos[position])
    }
    fun updateProducts(newProducts: List<Product>) {
        elementos = newProducts
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(elementos: Product) = with(itemView) {
            itemView.findViewWithTag<TextView>("show_id").text      = elementos.id
            itemView.findViewWithTag<TextView>("show_nombre").text  = elementos.title
            itemView.findViewWithTag<TextView>("show_precio").text  = elementos.price.toString()
            itemView.findViewWithTag<TextView>("show_stock").text   = elementos.category
            Picasso.get()
                .load(elementos.image)
                .placeholder(R.drawable.placeholder)
                .into(itemView.findViewById<ImageView>(R.id.showImage))
        }
    }
}