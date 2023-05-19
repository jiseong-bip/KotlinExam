package com.example.kotlinbasic.chap05.sec01

fun strAllCaps(str: String?){
    val strCaps: String? = str?.uppercase()
    println(strCaps)
}
fun main() {
    strAllCaps(null)
    strAllCaps("Kotlin")
}