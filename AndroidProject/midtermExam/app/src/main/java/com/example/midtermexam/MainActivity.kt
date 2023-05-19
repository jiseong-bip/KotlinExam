package com.example.midtermexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.midtermexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvInformation.text = "Information..."

        init()

    }

    private fun init() {
        with(binding){
            val listener = View.OnClickListener {
                when(it){
                    button -> binding.tvInformation.text = "버튼 1"
                    button2 -> binding.tvInformation.text = "버튼 2"
                    button3 -> binding.tvInformation.text = "버튼 3"
                }
            }
            button.setOnClickListener(listener)
            button2.setOnClickListener(listener)
            button3.setOnClickListener(listener)
        }
    }
}