package com.skytex.mercadoapp.domain.model



data class Product(
    val id:String,
    val title:String,
    val price:Double,
    val description:String,
    val category:String,
    val image:String,
    val rating:Rating
)

fun ProductModel.toDomain() = Product(id,title,price,description,category,image,rating)

