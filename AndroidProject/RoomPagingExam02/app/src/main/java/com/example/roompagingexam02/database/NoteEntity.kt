package com.example.roompagingexam02.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteEntity")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var noteIdx: Int? = null,
    val noteContent: String
)
