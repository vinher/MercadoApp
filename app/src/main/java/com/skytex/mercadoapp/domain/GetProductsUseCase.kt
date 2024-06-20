package com.skytex.mercadoapp.domain

import android.util.Log
import android.widget.Toast
import com.skytex.mercadoapp.data.ProductsRepository
import com.skytex.mercadoapp.domain.model.Product
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke():List<Product>{
        val products = productsRepository.getAllProductsFromApi()
        return if(products.isNotEmpty()){
            products
        }else{
            emptyList()
        }
    }

}