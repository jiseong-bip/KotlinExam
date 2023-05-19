package com.example.layoutinflaterexam01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_show: Button = findViewById(R.id.btn_show)
        val container: FrameLayout = findViewById(R.id.add_container)

        val inflater = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val partView = inflater.inflate(R.layout.activity_part, container, false)

        btn_show.setOnClickListener {
            val parent = partView.parent as ViewGroup?
            Log.d("parent", parent.toString())
            parent?.removeAllViews()

            container.addView(partView)
        }

    }
}