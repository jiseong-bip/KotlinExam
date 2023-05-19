package com.example.recyclerviewexam02

import android.view.View

interface OnItemViewClickListener {
    fun onItemViewClick(itemView: View, position: Int)
}