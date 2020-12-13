package com.devtech.firestoredemo.repo.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devtech.firestoredemo.repo.local.model.Products

interface ProductDao {

    @Query("SELECT * FROM Products")
    fun getproductList() : LiveData<List<Products>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Products)
}