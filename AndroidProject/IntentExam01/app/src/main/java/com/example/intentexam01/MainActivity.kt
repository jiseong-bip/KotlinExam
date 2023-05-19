package com.example.intentexam01

import android.content.Intent
import android.os.Build.VERSION_CODES.S
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val mIntent = Intent(this, SecondActivity::class.java)

            startActivity(mIntent)
        }
    }
}