package com.skytex.mercadoapp.domain.model

import com.google.gson.annotations.SerializedName

/*data class ProductModel(
    val id: String,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)*/

data class ProductModel(
    @SerializedName("id")           val id: Int,
    @SerializedName("title")        val title: String,
    @SerializedName("price")        val price: Double,
    @SerializedName("description")  val description: String,
    @SerializedName("category")     val category: String,
    @SerializedName("image")        val image: String,
    @SerializedName("rating")       val rating: Rating,
    @SerializedName("author")       val author: String
)
