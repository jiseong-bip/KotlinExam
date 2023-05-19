package com.example.kotlinbasic.chap07.sec02

fun main() {
    val result = data1 + data2
    println("result: ${result}")

    val obj = MyUser("a101", "손흥민")
    println("userId: ${obj.userId}, name: ${obj.name}")
}

var data1 = 100
var data2 = 200

class MyUser(var userId:String, var name: String)