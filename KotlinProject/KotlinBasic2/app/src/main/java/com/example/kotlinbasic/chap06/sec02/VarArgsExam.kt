package com.example.kotlinbasic.chap06.sec02

fun main() {
    val numArray = intArrayOf(7,8,9)
    val list = newIntList(1,2,3, *numArray, 5)
    println("list : $list")

    println("list.get(2) : ${list.get(2)}")

    list.set(0,100)
    println("list : $list")

    list.add(10)
    println("list : $list")

    list.remove(100)
    println("list : $list")

    varArgs(100,200,300)
    varArgs(100,200,300, 400, 500)
}

fun newIntList(vararg t: Int): ArrayList<Int> {
    val result = ArrayList<Int>()

    for (i in t) {
        print("$i, ")
        result.add(i)
    }
    println()
    return  result
}

fun varArgs(vararg num: Int) {
    for (i in num)
    {
        print("$i, ")
    }
    println()
}