package com.example.kotlinbasic.chap07.sec03

data class User(var id:Int, var name: String, var age: Int)

lateinit var user: User

fun main() {
    user =  User(101, "손흥민", 28)

    println("id: ${user.id}, name: ${user.name}, age: ${user.age}")
}