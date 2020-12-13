package com.devtech.firestoredemo.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devtech.firestoredemo.repo.local.dao.ProductDao
import com.devtech.firestoredemo.repo.local.model.Products

@Database(entities = [Products::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun productDao(): ProductDao

    companion object{
        const val DB_NAME  = "appdatabse.db"

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase {
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                    return INSTANCE!!
                }
            }
            return INSTANCE!!
        }

    }
}