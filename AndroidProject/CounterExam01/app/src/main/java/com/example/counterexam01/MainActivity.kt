package com.example.counterexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counterexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }//end of onCreate()

    fun init() {
        with(binding) {
            //초기값 설정
            binding.counterTv.text = "0"
            //증감 이벤트 처리
            binding.fabAdd.setOnClickListener {
                counter++
                binding.counterTv.text = counter.toString()
            }
            binding.fabRemove.setOnClickListener {
                counter--
                binding.counterTv.text = counter.toString()
            }
        }
    }
}