package com.example.logindbexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.logindbexam01.database.LoginDatabase
import com.example.logindbexam01.database.LoginEntity
import com.example.logindbexam01.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    //loginDao 인스턴스
    private val loginDao by lazy {
        LoginDatabase.getDatabase(this).logindao()
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** 회원가입 버튼 클릭했을 때 이벤트 처리 */
        binding.btnRegister.setOnClickListener {
            //username, password validation
            if (loginValidate()) {
                this.lifecycleScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) {
                        loginDao.inserUser(
                            LoginEntity(
                                userName = binding.editUsername.text.toString(),
                                userPass = binding.editPassword.text.toString()
                            )
                        )
                    }
                    clearTextField()
                    Toast.makeText(this@MainActivity, "유저 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                }//end of lifecycleScope.launch(Dispatchers.Main)
            }//end of if()
        }//end of btnRegister.setOnClickListener

        /** 로그인 버튼을 클릭했을 경우의 이벤트 */
        binding.btnLogin.setOnClickListener {
            //username, password validation
            if (loginValidate()) {
                this.lifecycleScope.launch(Dispatchers.Main) {
                    var userInfo: LoginEntity? = null

                    withContext(Dispatchers.IO) {
                        userInfo = loginDao.selectUser(
                            userName = binding.editUsername.text.toString(),
                            userPass = binding.editPassword.text.toString()
                        )
                    }//end of withContext(Dispatchers.IO)

                    userInfo?.let {
                        val mIntent = Intent(this@MainActivity, SecondActivity::class.java)

                        //LoginData 객체를 인텐트에 담아 SecondActivity에 전달
                        mIntent.putExtra(PARCABLE_USERINFO, it)
                        startActivity(mIntent)

                        //입력 필드 초기화
                        clearTextField()

                    } ?: kotlin.run {
                        //입력 필드 초기화
                        clearTextField()
                        Toast.makeText(this@MainActivity, "존재하지 않는 유저정보입니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }//end of lifecycleScope.launch(Dispatchers.Main)
            }//end of if()
        }//end of btnLogin.setOnClickListener
    }//end of onCreate()

    //username, password validation
    private fun loginValidate(): Boolean {
        if (binding.editUsername.text.toString().isBlank() || binding.editPassword.text.toString()
                .isBlank()
        ) {
            Toast.makeText(this, "아이디나 패스워드를 입력하셔야합니다.", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    //입력필드 초기화
    fun clearTextField() {
        binding.editUsername.setText("")
        binding.editPassword.setText("")
    }

    //PARCABLE_USERINFO 상수 선언
    companion object {
        const val PARCABLE_USERINFO = "PARCABLE_USERINFO"
    }
}