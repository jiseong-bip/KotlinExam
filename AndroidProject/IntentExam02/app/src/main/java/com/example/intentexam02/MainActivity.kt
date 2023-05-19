package com.example.intentexam02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentexam02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mActivityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnQuestions.setOnClickListener {
            Intent(baseContext, SecondActivity::class.java)?.let {
                it.putExtra("QUESTION", "현재 안드로이드 Version 및 API LEVLE은?")

                mActivityResultLauncher.launch(it)
            }
        }
        getResponseResult()
    }
    private fun getResponseResult() {
        mActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                val version = result.data?.getIntExtra("VERSION", 0)
                val level = result.data?.getStringExtra("API").orEmpty()
                binding.mainTvResult.text = "Answer: ver: $version, API: $level"
                Toast.makeText(this, "Answers: ver: $version, API: $level", Toast.LENGTH_LONG).show()
            }else {
                binding.mainTvResult.text = "RESULT_ERROR"
                Toast.makeText(this, "RESULT_ERROR", Toast.LENGTH_LONG).show()
            }
        }
    }
}