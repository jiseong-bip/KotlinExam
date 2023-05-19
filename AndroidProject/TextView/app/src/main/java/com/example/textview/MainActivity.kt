package com.example.textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tv_information)

        val btn01: Button = findViewById(R.id.btn_01)
        val btn02: Button = findViewById(R.id.btn_02)
        val btn03: Button = findViewById(R.id.btn_03)
        val btn04: Button = findViewById(R.id.btn_04)
        val btn05: Button = findViewById(R.id.btn_05)

        tvInfo.text = "information....."

        val listener = BtnListener()
        btn01.setOnClickListener(listener) //onClickListener 등록
        btn02.setOnClickListener(listener)

        val listener2 = View.OnClickListener {
            when(it?.id) {
                R.id.btn_03->tvInfo.text = "3번쩨 버튼"
                R.id.btn_04->tvInfo.text = "4번쩨 버튼"
            }
        }

        btn03.setOnClickListener(listener2)
        btn04.setOnClickListener(listener2)

        btn05.setOnClickListener {
            tvInfo.text = "5번재 버튼"
        }


    }

    inner class BtnListener : View.OnClickListener { //listener란 해당 버튼의 행동을 감지하는 녀석
        override fun onClick(v: View?) {//onClick method는 기본적으로 view를 받음
            when(v?.id) {
                R.id.btn_01->tvInfo.text = "1번쩨 버튼"
                R.id.btn_02->tvInfo.text = "2번쩨 버튼"
            }
        }
    }
}