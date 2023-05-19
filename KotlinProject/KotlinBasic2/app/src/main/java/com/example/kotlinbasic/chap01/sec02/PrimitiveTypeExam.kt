package com.example.kotlinbasic.chap01.sec02

fun main() {
    //정수형
    val v1: Int = 123
    val v2 = 123
    val v3 = 123L
    val v4: Byte = 123
    val v5: Short = 123
    var v6: Long = 123
    //v6 = v1 //Type mismatch, int != long
    v6 = v3

    //실수형
    val v7:Double = 123.4
    val v8 = 123.4
    val v9 = 3.14F //식별자 F에 의해 Float형 추론

    //문자 자료형
    val ch1: Char = 'A'
    val ch2 = ch1 + 1 //B, '문자 자료형 + 숫자'로 다른 문자 표현 가능
    val ch3 = 'c'
    //val ch4: Char = 65 //자바와 달리 숫자는 넣을 수 없음
    val ch5: Char = 65.toChar() //숫자는 타입 변환이 필요

    //형 변환
    val t: Byte = 65
    val t1 = t.toShort()
    val t2 = t.toInt()
    val t3 = t.toLong()
    val t4 = t.toFloat()
    val t5 = t.toDouble()

    println(t1)
}