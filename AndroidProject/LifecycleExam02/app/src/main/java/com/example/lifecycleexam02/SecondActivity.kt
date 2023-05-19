package com.example.lifecycleexam02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycleexam02.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    //바인딩 클래스 인스턴스 생성
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGotoFirst.setOnClickListener {
            finish()
        }
    }
}