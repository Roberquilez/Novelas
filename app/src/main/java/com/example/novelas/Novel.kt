package com.example.novelmanager

data class Novel(
    val title: String,
    val author: String,
    val synopsis: String,
    val year: Int,
    val isFavorite: Boolean = false
)