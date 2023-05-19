package com.example.parcelableexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parcelableexam01.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }
    fun loginAction() {
        val userId = binding.editId.text.toString()
        val userName = binding.editName.text.toString()

        if((!userId.isNullOrBlank())&&(!userName.isNullOrBlank())){
            val user = User(userId, userName)

            val loginIntent: Intent = Intent(this, SecondActivity::class.java).let{
                it.putExtra(USER, user)
            }

            if(loginIntent.resolveActivity(packageManager) != null) {
                startActivity(loginIntent)
            }

        } else {
            Toast.makeText(this, "Username/Password를 입력하세요", Toast.LENGTH_LONG).show()
        }
    }

    fun init() {
        with(binding){
            btnConfirm.setOnClickListener {
                loginAction()
            }
        }
    }
    companion object {
        const val USER = "USER"
    }
}