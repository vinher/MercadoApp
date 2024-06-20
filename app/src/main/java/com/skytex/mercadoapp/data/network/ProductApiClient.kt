package com.skytex.mercadoapp.data.network


import com.skytex.mercadoapp.domain.model.Product
import com.skytex.mercadoapp.domain.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductModel>>

}