package com.example.recyclerviewexam04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewexam04.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    fun init() {
        with(binding){
            val singerName = intent.getStringExtra(SINGER)

            val singerData = singerName?.let {
                SingerData.valueOf(it)
            }

            singerData?.let{
                imgSingerPhoto.setImageResource(singerData.imgRes)
                imgSingerPhoto.setImageResource(singerData.imgRes)
                tvSingerName.text = singerData.singer
                tvSingerSong.text = singerData.song
            }

            backBtn.setOnClickListener {
                finish()
            }
        }
    }

    companion object{
        const val SINGER = "SINGER"
    }
}