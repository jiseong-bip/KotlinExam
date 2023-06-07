package com.example.auctioninginfoapp.model

import android.bluetooth.BluetoothAssignedNumbers.APPLE

/** Fruits enum class
   - 농산물 상수명(품명, 품종코드)
 */
enum class Fruits(val holder: String, val scode: String) {
    APPLE("사과", "060103"),
    PEAR("배", "060201"),
    WATERMELON("수박", "080101"),
    KOREANMELON("참외", "080201"),
    TOMATO("토마토", "080301"),
    STRAWBERRY("딸기", "080401"),
    LEEK("부추", "101001"),
    CHILI("고추", "120501"),
    CUCUMBER("오이", "090101"),
    PUMPKIN("호박", "090201"),
    LETTUCE("상추", "100501"),
    EGG("깻잎", "101101")
}

