package com.example.kotlinbasic.chap01.sec02

fun main() {
    checkArgs("Kotlin")
    checkArgs(100)
    checkArgs(100.0)
}

fun checkArgs(type: Any) {
    when(type){
        is String -> println("type is String: $type")
        is Int -> println("type is Int: $type")
        is Double -> println("type is Double: $type")
    }
}