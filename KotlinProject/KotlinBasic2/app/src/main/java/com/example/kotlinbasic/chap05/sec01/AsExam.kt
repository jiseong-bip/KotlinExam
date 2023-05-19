package com.example.kotlinbasic.chap05.sec01

fun main() {
    val userId = 1001
    var IdCheck: String?

    IdCheck = userId as? String?

    println("idCheck : $IdCheck")
}