package com.example.logindbexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logindbexam.database.LoginEntity
import com.example.logindbexam.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** MainActivity에 전달한 LoginEntity 객체를 인텐트에서 추출
        - getParcelableExtra() 메서드를 이용하여 intent에서 객체(LoginEntity)를 복원
         */
        val user = intent.getParcelableExtra<LoginEntity>(MainActivity.PARCABLE_USERINFO)

        if (user != null) {
            Log.i("USER-DATA", "전달받은 유저정보는 ${user.userName} ${user.userPass} 입니다.")
        }

        // userName을 tv_username(activity_second.xml)에 표시
        if (user != null) {
            binding.tvUsername.text = "userName : ${user.userName}"
        }

        /* 뒤로가기를 누르면 앱 종료 */
        binding.btnFinish.setOnClickListener {
            finish()
        }
    }//end of onCreate()
}//end of SecondActivity