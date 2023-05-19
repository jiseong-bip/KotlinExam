package com.example.kotlinbasic.chap07.sec03

import com.example.kotlinbasic.chap09.sec03.CustomerManger

class CustomUser{
    lateinit var userID: String
}

fun main() {
    val obj = CustomUser()

    obj.userID = "jsJeon"
    println("userID : ${obj.userID}")
}