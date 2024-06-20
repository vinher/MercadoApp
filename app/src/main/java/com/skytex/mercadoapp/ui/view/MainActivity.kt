package com.skytex.mercadoapp.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skytex.mercadoapp.databinding.ActivityMainBinding
import com.skytex.mercadoapp.ui.adapters.ProductsAdapter
import com.skytex.mercadoapp.ui.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var recycler: RecyclerView
    private lateinit var ItemsProductAdapter:ProductsAdapter
    private val productsModels:ProductsViewModel by viewModels()
    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        viewModel.productModel.observe(this) { products ->
            products?.let {
                recycler = binding.showElements
                recycler.layoutManager = GridLayoutManager(this@MainActivity, 2)
                ItemsProductAdapter = (ProductsAdapter(productsModels.listaElmentos))
                recycler.adapter = ItemsProductAdapter
            }

        }
        viewModel.onCreate()
    }
}