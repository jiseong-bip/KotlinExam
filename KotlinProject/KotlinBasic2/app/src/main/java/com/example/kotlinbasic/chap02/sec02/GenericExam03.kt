package com.example.kotlinbasic.chap02.sec02

fun <T: Number> getSum(num1: T, num2: T): T
{
    return (num1.toDouble() + num2.toDouble()) as T
}

fun main() {
    println(getSum(10, 20))
    println(getSum(10.0f, 20.0f))
    println(getSum(10.0, 20.0))
    println(getSum(10, 20)::class.java)
    println(getSum(10.0f, 20.0f)::class.java)
    println(getSum(10.0, 20.0)::class.java)
}