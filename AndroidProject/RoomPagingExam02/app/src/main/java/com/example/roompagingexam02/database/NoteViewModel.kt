package com.example.roompagingexam02.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class NoteViewModel : ViewModel() {
    private lateinit var noteRepository: NoteRepository

    /** NoteViewModel 초기화 함수
     *  - noteRepository 속성 초기화
     * */
    fun initialize(repository: NoteRepository) {
        this.noteRepository = repository
    }

    /** PagingData를 반응형 데이터 스트림 형태로 반환
     *   - noteRepository.getItems() 함수를 호출하여
     *     PagingData를 가져와 공유할 수 있도록 데이터를 캐싱
     *  */
    fun getItems(): Flow<PagingData<NoteEntity>> {
        return noteRepository.getItems()
            .cachedIn(viewModelScope)
    }
}