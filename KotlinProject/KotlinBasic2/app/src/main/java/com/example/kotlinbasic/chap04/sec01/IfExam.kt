package com.example.kotlinbasic.chap04.sec01

fun main() {
    var x = 100

    if(x == 100){
        println("x = $x")
    } else {
        println("x는 100이 아님")
    }

    val msg = if(x == 100) "x = 100" else "x는 100이 아님"
    println(msg)

    println(if(x == 100) "x == 100" else "x는 100이 아님")
}