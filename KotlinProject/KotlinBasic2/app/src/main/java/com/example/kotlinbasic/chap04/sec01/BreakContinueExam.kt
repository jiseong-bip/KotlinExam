package com.example.kotlinbasic.chap04.sec01

fun main() {
    for(i in 1..10){
        if (i == 6) break
        print("$i, ")
    }
    println()

    for (i in 1..10)
    {
        if(i == 6) continue
        print("$i, ")
    }
    println()

    first@ for (i in 1..3) {
        for (j in 1..3) {
            println("i: $i, j: $j")
            if (j == 2) break@first
        }
    }
    println()

    first@ for (i in 1..3) {
        for (j in 1..3) {
            println("i: $i, j: $j")
            if (j==2) continue@first
        }
        println()
    }
}