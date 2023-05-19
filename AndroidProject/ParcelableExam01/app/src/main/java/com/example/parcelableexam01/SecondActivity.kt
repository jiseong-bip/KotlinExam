package com.example.parcelableexam01

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcelableexam01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val user = if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(MainActivity.USER, User::class.java)
            }else {
                intent.getParcelableExtra(MainActivity.USER)
            }
            user?.let {
                textMsg.text = "ID : ${it.userId}님의 이름은 ${it.userName} 입니다!!"
            }

            btnFinish.setOnClickListener {
                finish()
            }
        }
    }
}