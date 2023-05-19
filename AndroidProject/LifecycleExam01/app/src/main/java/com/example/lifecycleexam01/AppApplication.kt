package com.example.lifecycleexam01

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

open class AppApplication: Application() {
    val mPreferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }
}