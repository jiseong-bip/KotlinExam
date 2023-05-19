package com.example.recyclerviewexam02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam02.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = WorkoutAdapter(this)
        binding.workoutRv.adapter = adapter

        adapter.itemViewListener = object : OnItemViewClickListener {
            override fun onItemViewClick(itemView: View, position: Int) {
                val curPosition: Int = position
                val workout: WorkoutData = WorkoutData.values()[curPosition]
                val snack = Snackbar.make(itemView, "${workout.workName} selected!!", Snackbar.LENGTH_INDEFINITE)
                snack.setAction("확인", {
                    snack.dismiss()
                }).show()
            }
        }

        binding.workoutRv.layoutManager = LinearLayoutManager(this)
    }

}