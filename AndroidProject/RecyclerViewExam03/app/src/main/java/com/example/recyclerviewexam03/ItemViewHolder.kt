package com.example.recyclerviewexam03

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam03.databinding.ListItemBannerBinding
import com.example.recyclerviewexam03.databinding.ListItemShopBinding
import com.example.recyclerviewexam03.MainActivity.Companion.TAG

class BannerVeiwHolder(private val binding: ListItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindBanner(shopBanner: ShopBanner) {
        Log.d(TAG, "BannerViewHolder 클래스의 bindBanner 호출")
        binding.imgItemBanner.setImageResource(shopBanner.imageId)
    }
}

class ListItemViewHolder(private val binding: ListItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindItem(shopItem: ShopItem) {
        Log.d(TAG, "ListItemViewHolder 클래스의 bindBanner 호출")
        binding.imgShopItem.setImageResource(shopItem.imageId)
        binding.txtShopItemSubject.text = shopItem.itemName
        binding.txtShopItemPrice.text = String.format("%, d", shopItem.itemPrice)
    }
}