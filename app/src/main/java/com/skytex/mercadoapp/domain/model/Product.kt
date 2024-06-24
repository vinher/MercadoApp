package com.skytex.mercadoapp.domain.model

import com.skytex.mercadoapp.data.database.entities.ProductsEntities


data class Product(
    val id:Int,
    val title:String,
    val price:Double,
    val description:String,
    val category:String,
    val image:String,
    val rating: Rating
)
data class Rating(val rate:String,val count:String)
fun ProductModel.toDomain() = Product(id,title,price,description,category,image,rating)

fun ProductsEntities.toDomain() = Product(id,title,price,description,category,image,rating)

