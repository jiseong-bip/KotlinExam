package com.example.kotlinbasic.chap04.sec01

fun main() {
    val items = listOf("사과", "복숭아", "배")
    var index = 0

    while(index < items.size) {
        println("items[$index] : ${items[index]}")
        index++
    }

    println()

    index = 0
    do {
        println("items[$index] : ${items[index]}")
        index++
    }while (index < items.size)
}