package com.example.loginexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginexam01.databinding.ActivityMainBinding
import com.example.loginexam01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }
    fun init(){
        with(binding){
            intent.getStringExtra(MainActivity.USER_NAME).run {
                textMsg.text = this + "님"
            }

            btnFinish.setOnClickListener {
                finish()
            }
        }
    }
}