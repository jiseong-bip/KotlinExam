package com.example.recyclerviewexam02

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam02.databinding.ListItemWorkoutBinding

class WorkoutAdapter(private val context: Context) : RecyclerView.Adapter<WorkoutAdapter.ItemViewHolder>() {
    lateinit var itemViewListener: OnItemViewClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder {
        Log.d("WORKOUT", "onCreateViewHolder() 호출")
        val binding = ListItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutAdapter.ItemViewHolder, position: Int) {
        holder.workoutName.text = WorkoutData.values()[position].workName

        val animation = AnimationDrawable().apply {
            ContextCompat.getDrawable(context, WorkoutData.values()[position].firstImage)?.let{
                addFrame(it, 1000)
            }
            ContextCompat.getDrawable(context, WorkoutData.values()[position].secondImage)?.let{
                addFrame(it, 1000)
            }
        }

        animation.isOneShot = false

        holder.imgDetailWorkout.setImageDrawable(animation)
        animation.start()
    }

    override fun getItemCount(): Int {
        Log.d("WORKOUT", "getItemCoutn() 호출")
        return WorkoutData.values().size
    }

    inner class ItemViewHolder(private val binding: ListItemWorkoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener{
                itemViewListener?.onItemViewClick(itemView, adapterPosition)
            }
        }

        val workoutName = binding.tvWorkoutName
        val imgDetailWorkout = binding.imgDetailWorkout
    }
}