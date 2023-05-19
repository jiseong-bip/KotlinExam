package com.example.kotlinbasic.chap03.sec01

import com.google.android.material.color.utilities.Score

fun main() {
    val v1: Int = 100; val v2: Int = 200; val v3: Int = 100
    println("v1 == v2 : ${v1 == v2}")
    println("v1.equals(v3) : ${v1.equals(v3)}")
    val obj1 = Score(100, 200); val obj2 = Score( 300, 400)
    val obj3 = Score(100, 200)

    println("obj1 == obj2 : ${obj1 == obj2}")
    println("obj1 == obj3 : ${obj1 == obj3}")
    println("obj1.equals(obj3) : ${obj1.equals(obj3)}")
    println("obi1 !== obj3 : ${obj1 !== obj3}")

    var nullTest:String? = "Kotlin"
    println("nullTest?.length : ${nullTest?.length}") //Safe call(?.) null이 아니면 nullTest?.length를 반환 null이면 null 반환

    val length = nullTest?.length ?: -1 //Elvis 연산자 : null이 아니면 왼족 피연산자 값을 반환 Null이면 오른족 피연산자 값을 반환
    println("length : ${length}")
}

data class Score(val a:Int, val b:Int) {}