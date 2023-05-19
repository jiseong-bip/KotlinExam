package com.example.kotlinbasic.chap07.sec04

open class SuperClass{
    private var num = 0
    protected var num2 = 100

    protected  fun addFunc(): Int {
        num += 1
        return num
    }
}

class SubClass: SuperClass() {
    fun resultFunc() {
        var result = addFunc()
        println("result: ${result + num2}")
    }
}

fun main() {
    val obj = SubClass()

    obj.resultFunc()
}