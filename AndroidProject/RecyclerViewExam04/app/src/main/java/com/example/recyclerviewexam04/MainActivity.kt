package com.example.recyclerviewexam04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvSinger.addItemDecoration(divider)

        val adapter = SingerAdapter()
        binding.rvSinger.adapter = adapter

        adapter.itemViewListener = object : OnItemViewClickListener {
            override fun onItemViewClick(itemView: View, position: Int) {
                val curPosition: Int = position
                val singerData: SingerData = SingerData.values()[curPosition]

                val mIntent = Intent(baseContext, DetailActivity::class.java)

                Log.i("SINGER", "SingerData:" + singerData.singer)

                mIntent.putExtra(DetailActivity.SINGER, singerData.name)
                startActivity(mIntent)
            }
        }
        binding.rvSinger.layoutManager = LinearLayoutManager(this)
    }


}