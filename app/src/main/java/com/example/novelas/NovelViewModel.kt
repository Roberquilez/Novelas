package com.example.novelmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.novelas.Novel

class NovelViewModel(application: Application) : AndroidViewModel(application) {
    private val novels = MutableLiveData<List<Novel>>()

    fun getAllNovels(): LiveData<List<Novel>> {
        return novels
    }

    fun insert(novel: Novel) {
        val currentList = novels.value ?: emptyList()
        novels.value = currentList + listOf(novel)
    }

    fun delete(novel: Novel) {
        val currentList = novels.value ?: emptyList()
        novels.value = currentList - listOf(novel)
    }

    fun update(novel: Novel) {
        val currentList = novels.value?.toMutableList() ?: mutableListOf<Novel>()
        val index = currentList.indexOfFirst { it.title == novel.title }
        if (index != -1) {
            currentList[index] = novel
            novels.value = currentList
        }
    }
}