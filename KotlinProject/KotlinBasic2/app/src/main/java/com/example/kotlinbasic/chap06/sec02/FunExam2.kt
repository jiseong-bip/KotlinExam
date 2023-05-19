package com.example.kotlinbasic.chap06.sec02

fun main() {
    val num1 = 100
    val num2 = 200
    val result: Int

    result = compareFunc(num1, num2)
    println("result: $result")
}
fun compareFunc(x: Int, y: Int) = if(x>y) x else y