package com.devtech.firestoredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devtech.firestoredemo.repo.remote.FirestoreServiceClient

class MainActivity : AppCompatActivity() {
    lateinit var firestoreServiceClient: FirestoreServiceClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firestoreServiceClient = FirestoreServiceClient()
        firestoreServiceClient.getAllProducts()
    }
}