package com.skytex.mercadoapp.di

import android.content.Context
import androidx.room.Room
import com.skytex.mercadoapp.data.database.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val PRODUCTS_DATABASE_NAME = "products_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context,
        ProductsDatabase::class.java,PRODUCTS_DATABASE_NAME
    ) .build()

    @Singleton
    @Provides
    fun providesProdcutDao(db:ProductsDatabase) = db.getProductsDao()
}