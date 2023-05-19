package com.example.lifecycleexam02

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {
    // MediaPlayer 생성
    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.song)

    fun start() {
        mediaPlayer.start()//재생
    }

    fun pause() {
        mediaPlayer.pause()//일시정지
    }

    fun stop() {
        mediaPlayer.stop()//정지
        mediaPlayer.release()//메모리 해제
    }
}//end of MusicManager}