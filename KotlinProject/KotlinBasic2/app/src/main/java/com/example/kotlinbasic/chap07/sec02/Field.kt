package com.example.kotlinbasic.chap07.sec02

fun main() {
    var result = f1(100, 200)
    println(result)
}

fun f1(a1: Int, a2: Int) : Int {
    var count = a1 + a2
    return count
}