package com.example.recyclerviewexam03

interface ShopContent {
    val imageId: Int
}

data class ShopBanner(
    override val imageId: Int) : ShopContent

data class ShopItem(
    override val imageId: Int,
    val itemName: String,
    val itemPrice: Int
): ShopContent

enum class ShopData(val shopType:Int, val shopContent: ShopContent) {
    SHOP_ITEM1(ShopAdapter.BANNER,ShopBanner(R.drawable.banner_1)),
    SHOP_ITEM2(ShopAdapter.ITEM, ShopItem(R.drawable.shop1, " 샐러드", 2000)),
    SHOP_ITEM3(ShopAdapter.ITEM, ShopItem(R.drawable.shop2, "닭가슴살", 2500) ),
    SHOP_ITEM4(ShopAdapter.BANNER,ShopBanner(R.drawable.banner_2)),
    SHOP_ITEM5(ShopAdapter.ITEM, ShopItem(R.drawable.shop3, "한과", 1500)),
    SHOP_ITEM6(ShopAdapter.ITEM, ShopItem(R.drawable.shop4, "새우요리", 1700) ),
    SHOP_ITEM7(ShopAdapter.BANNER,ShopBanner(R.drawable.banner_3)),
    SHOP_ITEM8(ShopAdapter.ITEM, ShopItem(R.drawable.shop5, "과자", 2000)),
    SHOP_ITEM9(ShopAdapter.ITEM, ShopItem(R.drawable.shop6, "과일주스", 1500) ),
    SHOP_ITEM10(ShopAdapter.BANNER,ShopBanner(R.drawable.banner_4)),
    SHOP_ITEM11(ShopAdapter.ITEM, ShopItem(R.drawable.shop7, "사골육게장", 5000)),
    SHOP_ITEM12(ShopAdapter.ITEM, ShopItem(R.drawable.shop8, "자몽", 2000) )
}