package com.example.kotlinbasic.chap07.sec02

fun main() {
    val result = Mycalcu(100, 200)
    println(result.sum)
}

class Mycalcu constructor(_p1 : Int, _p2: Int) {
    var p1 : Int
    var p2: Int
    var sum: Int
    init {
        this.p1 =_p1
        this.p2 = _p2
        sum = p1 + p2
    }
}