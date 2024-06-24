package com.skytex.mercadoapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skytex.mercadoapp.data.database.entities.ProductsEntities
@Dao
interface ProductsDao {
    @Query("SELECT * FROM products_table")
    suspend fun getAllProducts():List<ProductsEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products:List<ProductsEntities>)

    @Query("DELETE FROM products_table")
    suspend fun deleteAllProducts()

}