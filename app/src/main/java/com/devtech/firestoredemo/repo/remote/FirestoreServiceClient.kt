package com.devtech.firestoredemo.repo.remote

import android.util.Log
import com.devtech.firestoredemo.repo.local.model.ProductResponse
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


    fun getAllProducts() {
        firebaseReference.get()
                .addOnSuccessListener { products ->
                    if (products.exists()) {
                        var list = products.data?.toList()

//                        var gson = Gson()
//                        var productResponse: ProductResponse = gson.fromJson<ProductResponse>(products.data.toString(),Products::class.java)

//                        Timber.e(" ProductResponse: ${productResponse}")
                        products.data?.forEach {
                            Timber.e("String Response: ${it.value}")


                        }


//                    Timber.e("$productList")

                        Log.d("FirestoreServiceClient", "DocumentSnapshot data: ${products.data.toString()}")
                    } else {
                        Log.d("FirestoreServiceClient", "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("FirestoreServiceClient", "get failed with ", exception)
                }
    }
}
