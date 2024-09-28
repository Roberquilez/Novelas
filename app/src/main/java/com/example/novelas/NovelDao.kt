package com.example.novelmanager

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NovelDao {
    @Insert
    fun insert(novel: Novel)

    @Delete
    fun delete(novel: Novel)

    @Query("SELECT * FROM novel_table ORDER BY title ASC")
    fun getAllNovels(): LiveData<List<Novel>>
}