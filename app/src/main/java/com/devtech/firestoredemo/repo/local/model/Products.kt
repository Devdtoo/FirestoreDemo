package com.devtech.firestoredemo.repo.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products (
    var name : String,
    @PrimaryKey
    var productId : String,
    var description : String,
    var cost : String,
    var markerImage : String,
    var productImage : String,
    var title : String,
    var discount : String
)