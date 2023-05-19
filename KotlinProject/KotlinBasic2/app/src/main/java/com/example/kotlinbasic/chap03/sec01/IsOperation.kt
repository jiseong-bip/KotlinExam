package com.example.kotlinbasic.chap03.sec01

fun main() {
    val obj1 = B()

    if (obj1 is A) {
        println("A class type")
    }else{
        println("Not A class")
    }

    if(obj1 is B){
        println("B class Type")
    }else {
        println("Not B class Type")
    }
}

open class A{}
class B : A() {}