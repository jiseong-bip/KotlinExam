package com.example.recyclerviewexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = Array<Message>(100) {
            Message("Message: ${it + 1}", false)
        }

        binding.rvView.adapter = MessageAdapter(data)

        binding.rvView.layoutManager = LinearLayoutManager(this)
    }
}