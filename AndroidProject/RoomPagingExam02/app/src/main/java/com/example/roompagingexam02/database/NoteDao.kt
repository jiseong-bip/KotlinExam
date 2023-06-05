package com.example.roompagingexam02.database

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(vararg notes: NoteEntity)

    @Query("SELECT * FROM NoteEntity ORDER BY noteContent ASC")
    fun selectNotes() : PagingSource<Int, NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE noteIdx = :noteIdx")
    fun selectNote(noteIdx: Int): NoteEntity

    @Update
    fun updateNote(vararg notes: NoteEntity)

    @Delete
    fun deleteNots(vararg note: NoteEntity)
}