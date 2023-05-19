package com.example.kotlinbasic.chap05.sec01

fun main() {
    val s: String? = null

    println(strLenFun(s))
    println(strLenFun("kotlin"))
}

fun strLenFun(str: String?): Int = str?.length?:0