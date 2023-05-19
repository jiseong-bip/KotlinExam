package com.example.kotlinbasic.chap02.sec02

import java.util.*

fun main() {
    val num = Array<Int>(10) { i -> i }
    // == num = Array(10, {i -> i})
    // == num = Array<Int>(10) {it}

    for (value in num) print("$value, ")

    println()

    val num2 = Array<String>(10) { it -> (it * 2).toString() }
    for (value in num2) {
        print("$value, ")
    }
    println()

    val num3 = Array(10) { _ -> 0 }
    num3.forEach { print("$it, ") }

    println()

    val num4 = Array(10) { i -> i * 3 }
    println("num4 : ${Arrays.toString(num4)}")
    println("num4 : ${num4.contentToString()}")
    // toString()은 객체 자체를 문자열로 표현하는데 사용되고, contentToString()은 배열의 내용을 문자열로 표현하는데 사용된다.

    val array2D = Array(2) {Array(3) { _ -> 0} }

    for (x in array2D.indices) {
        for (element in array2D[x]){
            print("$element")
        }
        println()
    }
    println()

    val array2D2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6))

    for (x in array2D2.indices) {
        for (element in array2D2[x]){
            print("$element")
        }
        println()
    }
    println()

    val array2D3 = Array(3) { x ->
        Array(3) { y ->
            when (x) {
                0 -> y
                1 -> y * 2
                else -> 0
            }
        }
    }
    for (x in array2D3.indices) {
        for (element in array2D3[x]){
            print("$element")
        }
        println()
    }

}

