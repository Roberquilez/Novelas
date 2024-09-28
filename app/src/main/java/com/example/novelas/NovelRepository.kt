package com.example.novelmanager

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NovelRepository(application: Application) {
    private val novelDao: NovelDao
    private val allNovels: LiveData<List<Novel>>
    private val executorService: ExecutorService

    init {
        val database = NovelDatabase.getInstance(application)
        novelDao = database.novelDao()
        allNovels = novelDao.getAllNovels()
        executorService = Executors.newFixedThreadPool(2)
    }

    fun insert(novel: Novel) {
        executorService.execute { novelDao.insert(novel) }
    }

    fun delete(novel: Novel) {
        executorService.execute { novelDao.delete(novel) }
    }

    fun getAllNovels(): LiveData<List<Novel>> {
        return allNovels
    }
}