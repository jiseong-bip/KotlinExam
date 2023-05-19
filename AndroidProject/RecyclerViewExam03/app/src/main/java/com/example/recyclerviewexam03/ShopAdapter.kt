package com.example.recyclerviewexam03

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam03.MainActivity.Companion.TAG
import com.example.recyclerviewexam03.databinding.ListItemBannerBinding
import com.example.recyclerviewexam03.databinding.ListItemShopBinding

class ShopAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        Log.d(TAG, "size: ${ShopData.values().size} - getItemCout() 호출 호출")

        return ShopData.values().size
    }

    override fun getItemViewType(position: Int): Int {
        Log.d(TAG, "shopType: ${ShopData.values()[position].shopType} - getItemViewType() 호출")

        return ShopData.values()[position].shopType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.d(TAG, "onCreateViewHolder() 호출")

        return when(viewType) {
            BANNER-> {
                BannerVeiwHolder(ListItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            ITEM -> {
                ListItemViewHolder(ListItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> {
                throw IllegalArgumentException(Error("매칭되는 뷰타입이 없습니다"))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder() 호출")

        when(holder) {
            is BannerVeiwHolder -> {
                holder.bindBanner(ShopData.values()[position].shopContent as ShopBanner)
            }
            is ListItemViewHolder -> {
                holder.bindItem(ShopData.values()[position].shopContent as ShopItem)
            }
        }
    }

    companion object{
        const val BANNER = 0
        const val ITEM = 1
    }

}