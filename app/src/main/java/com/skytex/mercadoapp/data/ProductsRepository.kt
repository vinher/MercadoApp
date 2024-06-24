package com.skytex.mercadoapp.data


import com.skytex.mercadoapp.data.database.dao.ProductsDao
import com.skytex.mercadoapp.data.database.entities.ProductsEntities
import com.skytex.mercadoapp.data.network.ProductsServices
import com.skytex.mercadoapp.domain.model.Product
import com.skytex.mercadoapp.domain.model.ProductModel
import com.skytex.mercadoapp.domain.model.toDomain
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val api:ProductsServices,
    private val productsDao: ProductsDao
){
    suspend fun getAllProductsFromApi():List<Product>{
        //Get all info
        val response:List<ProductModel> = api.getProducts()
        return response.map { it.toDomain() }
    }
    suspend fun getAllProductsFromDatabases():List<Product>{
        val response = productsDao.getAllProducts()
        return response.map { it.toDomain() }
    }
    suspend fun insertProducts(product:List<ProductsEntities>){
        productsDao.insertAll(product)
    }
    suspend fun clearProduct(){
        productsDao.deleteAllProducts()
    }

}