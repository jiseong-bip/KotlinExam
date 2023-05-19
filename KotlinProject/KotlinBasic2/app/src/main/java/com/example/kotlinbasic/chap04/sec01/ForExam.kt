package com.example.kotlinbasic.chap04.sec01

fun main() {
    //배열 생성
    val item1 = arrayOf("사과", "복숭아", "배")
    for (item in item1) {
        println("item1: $item")
    }
    println()

    for(i in item1.indices){
        println("item1[$i]: ${item1[i]}")
    }
    println()

    val item2 = listOf("서울", "경기", "인천")
    for (item in item2) {
        println("item2: $item")
    }
    println()

    for(i in item2.indices) {
        println("item2[$i] : ${item2[i]}")
    }
    println()

    var sum: Int = 0
    for (i in 1..10) sum += i
    println("sum: $sum")
    println()

    for (i in 1.. 10) print("$i, ")
    println()
    for (i in 10 downTo 1) print("$i, ")
    println()
    for (i in 10..10 step 2) print("$i, ")
    println()
    for (i in 10 downTo 1 step 2) print("$i, ")
}

