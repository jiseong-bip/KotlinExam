package com.example.layoutinflaterexam03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.layoutinflaterexam03.databinding.ActivityMainBinding
import com.example.layoutinflaterexam03.databinding.ActivitySubBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subBinding: ActivitySubBinding //layout class 화 했음

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        subBinding = ActivitySubBinding.inflate(layoutInflater)

        setContentView(binding.root) //layout view의 최상의 root view

        init()
    }
    private fun init() {
        binding.addLayout.addView(subBinding.root)

        with(subBinding) {
            radioGroup.setOnCheckedChangeListener { _, checkId ->
                when(checkId) {
                    R.id.radioButton1 -> Toast.makeText(baseContext, "여성입니다!", Toast.LENGTH_LONG).show()
                    R.id.radioButton2 -> Toast.makeText(baseContext, "남성입니다!", Toast.LENGTH_LONG).show()
                }
            }
            checkbox1.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked) {
                    Toast.makeText(applicationContext, "취미가 등산이군요!!", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(baseContext, "등산 체크박스 해제!", Toast.LENGTH_LONG).show()
                }
            }
            checkbox2.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked) {
                    Toast.makeText(baseContext, "취미가 영화감이군요!!", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(baseContext, "영화감상 체크박스 해제!", Toast.LENGTH_LONG).show()
                }
            }
            checkbox3.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked) {
                    Toast.makeText(baseContext, "취미가 운동이군요!!", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(baseContext, "운동 체크박스 해제!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}