package com.example.lifecycleexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lifecycleexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /** 공유 클래스(AppApplication)에 선언된 SharedPreference(mPreferences) 인스턴스를 가져온다.
    - 공유 클래스에서 선언된 멤버를 사용하기 위해서 Application Context를 가져와
    공유 클래스 타입으로 캐스팅한 후 멤버(mPreferences)를 사용
     */
    private val mPreferences by lazy { (application as AppApplication).mPreferences }
//    val mPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

    var mScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("LIFECYCLE", "MainActivity onCreate")

        init()
    }
    /** Activity Lifecycle 콜백 함수 오버라이딩 */
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "MainActivity onResume")

        /** onResume()일 때 SharedPreference에서 SCORE 점수 추출(getInt(지정한 key, 반환할 기본값)) */
        var score = mPreferences.getInt(SCORE, 0).toString()
        binding.textView.text = mPreferences.getInt(SCORE, 0).toString()

        Toast.makeText(this, "score : $score", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "MainActivity onPause")

        /** onPause()일 때 SharedPreference에 SCORE 점수 누적
         * - SharedPreferences 파일에 저장하려면 SharedPreferences에서 edit()를
        사용하여 putInt() 및 putString() 메서드를 사용하여 키와 값을 넣은 후
        apply() 또는 commit()을 호출하여 변경사항을 저장
         */
        mPreferences.edit().putInt(SCORE, (mScore + 5000)).apply()
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "MainActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "MainActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "MainActivity onDestory")
    }

    private fun editAction() {
        val userName = binding.editUsername.text.toString()
        val password = binding.editPassword.text.toString()

        if ((!userName.isNullOrBlank()) && (!password.isNullOrBlank())) {
            //인텐트 생성
            val myIntent = Intent(this, SecondActivity::class.java)

            /** userName을 SharedPreference에 저장(key-vlaue 구조로 저장)
            - apply() : 비동기방식으로 백그라운드 스레드에서 SharedPreferences를 저장
            - commit() : 메인 스레드에서 SharedPreferences를 저장
             */
            /** mPreferences.edit().putString(USER_NAME, userName).apply() */
            mPreferences.edit().putString(USER_NAME, userName).apply()

                /** 여러 개를 put 한 후 마지막에 변경사항을 저장 */

            /** SCORE 키에 저장된 점수를 가져온다. */
            mScore = mPreferences.getInt(SCORE, 0)

            startActivity(myIntent)
        } else {
            Toast.makeText(this, "아이디를 입력하세요", Toast.LENGTH_LONG).show()
        }
    }//end of editAction()

    fun init() {
        with(binding) {
            btnLogin.setOnClickListener {
                editAction()
            }
        }
    }//end of init()
    /** companion object 불럭({}) 안에 static 접근을 허용할 변수(프로퍼티)와 메서드(함수) 등을 선언
    - 코틀린에서는 static 키워드가 없음
    - Companion object 를 내에 선언한 변수와 메서드는 java 에서 사용하는 static 형태로 사용할 수 있음
    - Companion object 내에 선언된 변수와 메서드 접근 방법 : 클래스명.변수명(또는 메서드명)
     */
    companion object {
        const val USER_NAME = "USER_NAME"
        const val SCORE = "SCORE"
    }

//    //username을 SharedPreferences 파일로 저장
//    fun setString(context : Context, key : String, value : String) {
//        /* SharedPreferences 객체 참조
//           - PREFS_FILENAME : file name
//           - MODE_PRIVATE : 이 앱에서만 사용하도록 모드 설정
//         */
//        val prefs = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
//        //SharedPreferences Editor 객체 참조
//        val editor = prefs!!.edit()
//        /* 데이터 저장(key-vlaue 구조로 저장)
//           - apply() : 비동기방식으로 백그라운드 스레드에서 SharedPreferences를 저장
//           - commit() : : 메인 스레드에서 SharedPreferences를 저장
//         */
//        editor.putString(key, value).apply()
//    }
//
//    //SharedPreferences 파일에서 username을 읽어온다.
//    fun getString(context : Context, key : String) : String {
//        //SharedPreferences 객체 참조
//        val prefs = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
//        //저장된 key값을 가져온다.
//        return prefs.getString(key, "")
//    }
}