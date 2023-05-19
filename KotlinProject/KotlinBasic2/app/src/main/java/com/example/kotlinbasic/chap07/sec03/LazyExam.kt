package com.example.kotlinbasic.chap07.sec03

fun main() {
    val account = Account()

    println(account.balance)
    println("========================")
    println("count.balance : ${account.balance}")
}

class Account() {
    init {
        println("init block")
    }

    val balance: Int by lazy {
        print("Setting balance: ")
        10000
    }
}