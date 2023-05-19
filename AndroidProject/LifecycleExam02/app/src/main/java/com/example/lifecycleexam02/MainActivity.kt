package com.example.lifecycleexam02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycleexam02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //바인딩 클래스 인스턴스 생성
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** 옵저버(MusicObserver) 등록
        - 옵저버를 생성(MusicObserver(this))할 때 인자로 this(==MainActivity)를 넘겨주면,
        옵저버에서 MainActivity에 접근하여 현재 상태를 알기 때문에 생명주기에 맞춰
        제어를 할 수 있음
        - 옵저버 객체를 생성한 후 lifecycle 객체에 등록
        (AppCompatActivity는 내부적으로 LifecycleOwner를 구현하고 있기 때문에
        Activity는 lifecycle 객체를 직접 참조할 수 있음)
         */
        lifecycle.addObserver(MusicObserver(this))
        //this.getLifecycle().addObserver((LifecycleObserver)(new MusicObserver((Context)this)));

        /* 두번째 액티비티로 이동합니다.*/
        binding.btnGotoSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}