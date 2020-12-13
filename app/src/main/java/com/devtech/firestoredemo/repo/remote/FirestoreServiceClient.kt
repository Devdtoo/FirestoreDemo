package com.devtech.firestoredemo.repo.remote

import com.devtech.firestoredemo.repo.local.model.Products
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import timber.log.Timber

class FirestoreServiceClient {
    var productList = mutableListOf<Products>()
    val firebaseReference = FirebaseFirestore.getInstance()
            .document("Products/007")

/*        {
            "iPhone":{
            "description":"This is iPhone 12 having 8gb RAM, 64gb storage",
            "title":"iPhone 12",
            "discount":"10%",
            "productId":"02",
            "name":"iPhone",
            "markerImage":"https://google.com",
            "productImage":"https://google.com",
            "cost":"80k"
        },
            "Macbook":{
            "description":"This is iPhone 12 having 8gb RAM, 64gb storage",
            "title":"iPhone 12",
            "discount":"10%",
            "productId":"02",
            "name":"iPhone",
            "markerImage":"https://google.com",
            "productImage":"https://google.com",
            "cost":"80k"
        },
            "iPad":{
            "description":"This is iPhone 12 having 8gb RAM, 64gb storage",
            "title":"iPhone 12",
            "discount":"10%",
            "productId":"02",
            "name":"iPhone",
            "markerImage":"https://google.com",
            "productImage":"https://google.com",
            "cost":"80k"
        }
        }*/


    fun getAllProducts(onSuccess : (List<Products>?)-> Unit) {
        firebaseReference.get()
                .addOnSuccessListener { products ->
                    if (products.exists()) {
                        var gson = Gson()
                        products.data?.forEach {
                            var responseInJson = gson.toJson(it.value).toString()
                            var productResponse = gson.fromJson<Products>(responseInJson, Products::class.java)
                            productList.add(productResponse)
                        }
                        onSuccess(productList)
                    Timber.e("Product Lust Response: $productList")
                    } else {
                        Timber.e("No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Timber.e("get failed with $exception")
                    onSuccess(null)
                }
    }
}
