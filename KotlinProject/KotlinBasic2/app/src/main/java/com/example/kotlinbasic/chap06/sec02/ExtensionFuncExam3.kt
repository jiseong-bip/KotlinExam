package com.example.kotlinbasic.chap06.sec02

fun main() {
    val obj = ExtensionFuncExam3()
    println("data ${obj.data}, eData: ${obj.eData}")
    obj.infoFunc()
    obj.eFunc()
}

class ExtensionFuncExam3 {
    val data: Int = 100
    fun infoFunc() {
        println("infoFunc() 호출")
    }
}

val ExtensionFuncExam3.eData : Int
    get() =200

fun ExtensionFuncExam3.eFunc() {
    println("eFunc() 호출")
}