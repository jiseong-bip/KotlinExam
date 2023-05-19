package com.example.kotlinbasic.chap04.sec01

fun main() {
    whenUsage(2, 50, "서울특별시")
}

fun whenUsage(inputType: Int, score: Int, city: String) {
    when(inputType) {
        1 -> println("Type-1")
        2,3 -> println("type-2-3")
        else -> {
            println("Type-Unideified")
        }
    }
    when (inputType) {
        checkInputType(inputType) -> {
            println("Type normal")
        }
        else -> println("Type abnormal")
    }
    var start = 0; val end = 100
    when(score) {
        in start..(end/4) -> println("be within 25%")
        50 -> println("average")
        in start..end -> println("be within range")
        else -> println("out of range")
    }

    val isSeoul = when(city) {
        is String -> city. startsWith("서울")
        else -> false
    }
    println(isSeoul)

    when{
        city.isEmpty()              -> println("도시명이 없습니다")
        city.substring(0,2) == "서울" -> println("city: $city")
        else -> println(city)
    }
}

fun checkInputType(inputType: Int): Int {
    return if (inputType in 1..3) inputType else -1
}