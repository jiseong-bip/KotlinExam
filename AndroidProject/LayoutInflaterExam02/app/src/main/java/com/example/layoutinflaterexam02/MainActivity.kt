package com.example.layoutinflaterexam02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.layoutinflaterexam02.databinding.ActivityMainBinding
import com.example.layoutinflaterexam02.databinding.ActivityPartBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var partBinding : ActivityPartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        partBinding = ActivityPartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val parent = partBinding.root.parent as ViewGroup?
            Log.d("parent", parent.toString())
            parent?.removeAllViews()

            binding.addContainer.addView(partBinding.root)
        }

    }
}