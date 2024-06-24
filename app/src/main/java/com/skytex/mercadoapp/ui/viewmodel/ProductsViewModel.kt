package com.skytex.mercadoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skytex.mercadoapp.domain.GetProductsUseCase
import com.skytex.mercadoapp.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase

) : ViewModel() {
    val productModel = MutableLiveData<Any>()
    lateinit var listaElmentos: ArrayList<Product>
    fun onCreate() {
        listaElmentos = arrayListOf()
        viewModelScope.launch {
            //Consumimos la peticion
            val result = getProductsUseCase()
            if (!result.isNullOrEmpty()) {
                productModel.postValue(result)
                result.forEach { index ->
                    listaElmentos.add(
                        Product(
                            index.id,
                            index.title,
                            index.price,
                            index.description,
                            index.category,
                            index.image,
                            index.rating
                        )
                    )
                }


            } else {
                Log.e("Data", "Algo Salio Mal")
            }
        }
    }


}