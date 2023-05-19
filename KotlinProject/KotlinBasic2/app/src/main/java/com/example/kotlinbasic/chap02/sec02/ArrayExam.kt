package com.example.kotlinbasic.chap02.sec02

import java.util.*

fun main() {
    val itemString = arrayOf<String>("사과", "복숭아", "배")

    for(fruit in itemString) println("fruit : $fruit")

    println()

    val numArray = arrayOf<Int>(1,2,3,4,5)

    for (num in numArray) print("$num, ")

    println()

    val itemAny = arrayOf("Kotlin", 100, "java", 97, true)

    for(item in itemAny) print("$item, ")

    println()
    //2) arrayofNulLs() 함수 : nuLL 값을 가지는 배열 생성(크기만 지정)
    val arr1 = arrayOfNulls<Int>(3)//크기가 3인 정수(Int) 타입 배열 생성
    arr1[0] = 10
    arr1[1] = 20
    arr1[2] = 30
    for (i in arr1){
        print("$i, ")
    }
    println()
    val arr2 = arrayOfNulls<String>(3)//크기가 3인 String 타입 배열 생성
    for (value in arr2){
        print ("$value, ")
    }
    println()
    arr2[0] = "Kotlin"
    arr2[1] = "Java"
    arr2[2] = "Swift"
    for (value in arr2) {
        println("arr2 : $value")
    }
}