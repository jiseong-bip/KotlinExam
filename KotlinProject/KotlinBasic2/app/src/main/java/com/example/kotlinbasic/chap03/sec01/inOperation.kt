package com.example.kotlinbasic.chap03.sec01

fun main() {
    val num = arrayOf(100, 200, 300, 400, 500)
    println("${200 in num}")
    println("${num.contains(200)}")
    println("${200 !in num}")
    println("${!num.contains(200)}")

    for(i in num){
        print("$i, ")
    }
}