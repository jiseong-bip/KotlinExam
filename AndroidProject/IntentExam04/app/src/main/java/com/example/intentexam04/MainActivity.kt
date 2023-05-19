package com.example.intentexam04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentexam04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val recipient = binding.editRecipient.text.toString().trim()
            val subject = binding.editSubject.text.toString().trim()
            val message = binding.editMessage.text.toString().trim()

            if(recipient.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "입력 필드를 확인해주세요.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"

                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }

            startActivity(Intent.createChooser(emailIntent, "Send email using:"))

        }
    }
}