package com.example.lifecycleexam02

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MusicObserver(val context: Context) : DefaultLifecycleObserver {

    //미디어 재생을 위한 MusicManager 참조
    private val musicManager: MusicManager by lazy { MusicManager(context) }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("LOG", "ON_CREATE")
        Toast.makeText(context, "ON_CREATE 액티비티를 생성합니다.", Toast.LENGTH_LONG).show()
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("LOG", "ON_START")
        Toast.makeText(context, "ON_START 동작을 준비합니다.", Toast.LENGTH_LONG).show()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("LOG", "ON_RESUME")
        Toast.makeText(context, "ON_RESUME 음악을 재생합니다.", Toast.LENGTH_LONG).show()
        musicManager.start()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("LOG", "ON_PAUSE")
        Toast.makeText(context, "ON_PAUSE 음악을 중지합니다.", Toast.LENGTH_LONG).show()
        /** 아래 메서드를 주석처리하면 액티비티 이동후에도 음악은 계속 흘러 나옵니다.*/
        musicManager.pause()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("LOG", "ON_STOP")
        Toast.makeText(context, "ON_STOP 액티비티가 완전히 보이지 않습니다.", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("LOG", "ON_DESTROY")
        Toast.makeText(context, "ON_DESTROY 액티비티를 종료합니다.", Toast.LENGTH_LONG).show()
        musicManager.stop()
    }
}//end of MusicObserver