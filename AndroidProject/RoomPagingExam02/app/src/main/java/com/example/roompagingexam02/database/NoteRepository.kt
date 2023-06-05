package com.example.roompagingexam02.database

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {
    fun getItems(): Flow<PagingData<NoteEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { noteDao.selectNotes() }
        ).flow /** emits new instances of PagingData */
    }
}
