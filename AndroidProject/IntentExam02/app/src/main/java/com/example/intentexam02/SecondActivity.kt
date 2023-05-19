package com.example.intentexam02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentexam02.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setContentView(binding.root)

        if(intent.hasExtra("QUESTION")) {
            var question = intent.getStringExtra("QUESTION")
            binding.secondTvTitle.text = "Question: $question"
            Toast.makeText(this, "Question: $question", Toast.LENGTH_LONG).show()
        }

        binding.btnAnsewr.setOnClickListener {
            val sIntent = Intent()
            sIntent.putExtra("VERSION", 13)
            sIntent.putExtra("API", "LEVEL 33")

            setResult(RESULT_OK, sIntent)
            finish()
        }
    }
}