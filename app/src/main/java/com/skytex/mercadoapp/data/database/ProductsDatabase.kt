package com.skytex.mercadoapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skytex.mercadoapp.data.database.dao.ProductsDao
import com.skytex.mercadoapp.data.database.entities.ProductsEntities

@Database(entities = [ProductsEntities::class], version = 1)
abstract class ProductsDatabase:RoomDatabase() {
    abstract fun getProductsDao():ProductsDao
}