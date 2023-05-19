package com.example.kotlinbasic.chap05.sec01

fun main() {
    ignoreNulls("Kotlin")
}

fun ignoreNulls(s: String?){
    val sNotNull: String = s!! // !!는 s가 null이 아님을 선언
    println("sNotNull.length: ${sNotNull.length}")
}