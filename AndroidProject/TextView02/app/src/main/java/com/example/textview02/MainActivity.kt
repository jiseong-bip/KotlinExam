package com.example.textview02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.textview02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.tvInformation.text = "information...."

        init()
    }
    fun init() {
        with(binding) {
            val listener = View.OnClickListener {
                when(it) {
                    btn01 -> binding.tvInformation.text = "1번째 버튼"
                    btn02 -> binding.tvInformation.text = "2번째 버튼"
                    btn03 -> binding.tvInformation.text = "3번째 버튼"
                    btn04 -> binding.tvInformation.text = "4번째 버튼"
                    btn05 -> binding.tvInformation.text = "5번째 버튼"
                }
            }

            btn01.setOnClickListener(listener)
            btn02.setOnClickListener(listener)
            btn03.setOnClickListener(listener)
            btn04.setOnClickListener(listener)
            btn05.setOnClickListener(listener)
        }
    }
}