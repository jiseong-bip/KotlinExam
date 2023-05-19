package com.example.recyclerviewexam03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG: String = "로그"
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycleShop.adapter = ShopAdapter()
        binding.recycleShop.layoutManager = LinearLayoutManager(this)
    }
}