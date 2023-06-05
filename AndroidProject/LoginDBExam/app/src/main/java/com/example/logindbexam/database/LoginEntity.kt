package com.example.logindbexam.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class LoginEntity (
    @PrimaryKey
    val userName: String,
    val userPass: String
) : Parcelable
