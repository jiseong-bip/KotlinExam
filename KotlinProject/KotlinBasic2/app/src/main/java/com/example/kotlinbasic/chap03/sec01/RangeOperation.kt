package com.example.kotlinbasic.chap03.sec01

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val lowerAlphaRange = 'a'..'z'
    val numberRange = 1 .. 100
    println("isLower: ${'d' in lowerAlphaRange}")
    println("inNumber : ${101 in numberRange}")

    for(i in 1..10) print("$i, ")
    for(i in 'a'..'z') print("$i, ")

    val start = LocalDate.now()
    println("start : $start")

    val end = start..start.plusDays(5)
    println("end : $end")

    println("add weeks : ${start.plusWeeks(1)}")
    println("add weeks : ${start..start.plusWeeks(1)}")

}