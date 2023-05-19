package com.example.lifecycleexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycleexam01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    /** 공유 클래스(AppApplication)에 선언된 SharedPreference(mPreferences) 인스턴스를 가져온다. */
    val mPreferences by lazy { (application as AppApplication).mPreferences }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("LIFECYCLE", "SecondActivity onCreate")

        /** MainActivity에서 보낸 인텐트에서 USER_NAME 추출 */
        val userName = mPreferences.getString(MainActivity.USER_NAME, "")

        userName?.let { binding.textMsg.text = it + "님이 로그인하였습니다!!" }

        /** 뒤로가기를 누르면 앱을 종료합니다.*/
        binding.btnFinish.setOnClickListener {
            finish()
        }
    }
    //Activity Lifecycle 콜백 함수 오버라이딩
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "SecondActivity onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "SecondActivity onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "SecondActivity onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "SecondActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "SecondActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "SecondActivity onDestroy")
    }
}