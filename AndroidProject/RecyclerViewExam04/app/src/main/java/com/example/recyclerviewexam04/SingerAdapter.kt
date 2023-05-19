package com.example.recyclerviewexam04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam04.databinding.ListItemSingerBinding





class SingerAdapter() : RecyclerView.Adapter<SingerAdapter.ItemViewHolder>() {
    lateinit var itemViewListener: OnItemViewClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : ItemViewHolder {
        val binding = ListItemSingerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SingerAdapter.ItemViewHolder, position: Int) {
        holder.bindSingerData(SingerData.values()[position])
    }

    override fun getItemCount(): Int {
        return SingerData.values().size
    }

    inner class ItemViewHolder(private val binding: ListItemSingerBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                itemViewListener?.onItemViewClick(itemView, adapterPosition)
            }
        }
        fun bindSingerData(singerData: SingerData) {
            binding.tvItemSinger.text = singerData.singer
            binding.tvItemSong.text = singerData.song
            binding.imgPhoto.setImageResource(singerData.imgRes)
        }
    }



}