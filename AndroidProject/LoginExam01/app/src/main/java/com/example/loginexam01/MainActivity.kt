package com.example.loginexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    fun logInAction() {
        val userName = binding.editUsername.text.toString()
        val password = binding.editPassword.text.toString()

        if((!userName.isEmpty())&&(!password.isEmpty())) {
            Intent(this, SecondActivity::class.java).apply {
                this.putExtra(USER_NAME, userName)

                if(this.resolveActivity(packageManager) != null)
                    startActivity(this)
            }
        } else {
            Toast.makeText(this, "Username/Password를 입력하세요", Toast.LENGTH_LONG).show()
        }
    }

    fun init() {
        with(binding) {
            btnLogin.setOnClickListener {
                logInAction()
            }
        }
    }

    companion object {
        const val USER_NAME = "USER_NAME"
    }
}