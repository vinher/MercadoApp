package com.skytex.mercadoapp.data.database.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skytex.mercadoapp.domain.model.Product
import com.skytex.mercadoapp.domain.model.Rating


@Entity(tableName = "products_table")
data class ProductsEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "price") val price:Double,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "category") val category:String,
    @ColumnInfo(name = "image") val image:String,
    @ColumnInfo(name = "rating") val rating: Rating
)

fun Product.toDatabase() = ProductsEntities(
    id = id,
    title = title,
    price = price,
    description = description,
    category = category,
    image = image,
    rating = rating
)