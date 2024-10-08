package com.example.novelas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "novel_table")
data class Novel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val synopsis: String,
    val year: Int,
    val isFavorite: Boolean = false
)