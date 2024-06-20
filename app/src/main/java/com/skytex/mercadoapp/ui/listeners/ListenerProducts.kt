package com.skytex.mercadoapp.ui.listeners

import com.skytex.mercadoapp.domain.model.Product

interface ListenerProducts {
    fun onClick(item:Product, position:Int)
}