package com.devtech.firestoredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.devtech.firestoredemo.repo.ProductRepository
import com.devtech.firestoredemo.repo.remote.FirestoreServiceClient
import com.devtech.firestoredemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        viewModel = ViewModelProvider(this, MyViewModelFactory<MainViewModel>(MainViewModel(ProductRepository(this,this)))).get(MainViewModel::class.java)

    }
}