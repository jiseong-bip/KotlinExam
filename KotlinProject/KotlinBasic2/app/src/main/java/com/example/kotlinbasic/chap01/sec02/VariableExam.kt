package com.example.kotlinbasic.chap01.sec02

fun main() {
    var a: Int = 100
    var b = 200
    var c: Int

    val d: Int = 1000
    val e = "Kotlin"

    println("a: $a")
    println("b: $b")

    c = a + b
    println("c: $c")
    println("a + b = ${a + b}")

    println("d: $d")
    println("e: $e")

    var flag = true
    println("flag : $flag")

    flag = false
    println("flag : $flag")

    val flag2 = "true"
    println("flag2 : $flag2")
    println("flag : ${flag2::class.java}")
    println("flag2 : ${flag2.toBoolean()}")
    println("flag2 : ${flag2.toBoolean()::class.java}")

    val flag3 = "false"
    println("flag3 : ${flag3.toBoolean()}")


}