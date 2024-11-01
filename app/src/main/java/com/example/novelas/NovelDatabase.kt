package com.example.novelmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novelas.Novel

@Database(entities = [Novel::class], version = 1)
abstract class NovelDatabase : RoomDatabase() {
    abstract fun novelDao(): NovelDao

    companion object {
        @Volatile
        private var INSTANCE: NovelDatabase? = null

        fun getInstance(context: Context): NovelDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NovelDatabase::class.java,
                    "novel_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}