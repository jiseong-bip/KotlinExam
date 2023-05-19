package com.example.kotlinbasic.chap06.sec02

fun main() {
    val str = "Hello, Kotlin"
    println(str.lastString())
}
fun String.lastString() :String{
    println("str: $this")
    return this.get(this.length - 1).toString()
}