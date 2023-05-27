package com.example.navigationex02

import androidx.annotation.DrawableRes

data class FriendsData(
    val friendName: String,
    val englishName: String,
    @DrawableRes val imageResource: Int,
    val friendRank: Int
)