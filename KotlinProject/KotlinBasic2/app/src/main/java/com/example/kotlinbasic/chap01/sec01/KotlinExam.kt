package com.example.kotlinbasic.chap01.sec01

fun main() {
    println(makeMsg1(1))
    println(makeMsg1(2))
    println(makeMsg2(1))
    println("makeMsg3(1): ${makeMsg3(1)}")
    println("makeMsg4(2): ${makeMsg4(2)}")
}

fun makeMsg1(msgType:Int):String{
    return if(msgType==1){
        "대한민국"
    }else{
        "Korea"
    }
}

fun makeMsg2(msgType: Int):String{
    return if (msgType==1) "대한민국" else "Korea"
}

fun makeMsg3(msgType: Int):String = if (msgType==1) "안녕" else "Hi~!"

fun makeMsg4(msgType: Int)= if (msgType==1) "코틀린" else "Kotlin"