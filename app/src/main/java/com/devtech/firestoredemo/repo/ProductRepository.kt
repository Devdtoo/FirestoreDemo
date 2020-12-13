package com.devtech.firestoredemo.repo

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.devtech.firestoredemo.repo.local.AppDatabase
import com.devtech.firestoredemo.repo.local.model.Products
import com.devtech.firestoredemo.repo.remote.FirestoreServiceClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val context : Context, private val lifecycleOwner: LifecycleOwner){
    var productList = mutableListOf<Products>()
    private var appDatabase = AppDatabase.getInstance(context)



    suspend fun getAllProductsFromFirestoreAndInsertInDb(){
        val firestoreServiceClient = FirestoreServiceClient()
        withContext(Dispatchers.IO){
            firestoreServiceClient.getAllProducts{
                if (!it.isNullOrEmpty()){
                    it.forEach {
                        appDatabase.productDao().insertProduct(it)
                    }
                }
            }
        }
    }

    fun queryProductDataFromRoomDb(onSuccess : (List<Products>)-> Unit){
        appDatabase.productDao().getproductList().observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                onSuccess(it)
            }
        })
    }

}