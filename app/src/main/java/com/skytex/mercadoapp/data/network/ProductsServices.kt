package com.skytex.mercadoapp.data.network

import com.skytex.mercadoapp.domain.model.ProductModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ProductsServices @Inject constructor(private val apiClient: ProductApiClient) {
    suspend fun getProducts():List<ProductModel>{
        return with(Dispatchers.IO){
            val response = apiClient.getAllProducts()
            response.body()?: emptyList()
        }
    }
}