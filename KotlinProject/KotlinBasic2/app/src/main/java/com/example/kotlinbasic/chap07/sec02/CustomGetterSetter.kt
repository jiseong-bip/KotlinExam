package com.example.kotlinbasic.chap07.sec02

fun main() {
    val s1 = Student(101, "전지성", 27)
    println("id: ${s1.id}, name: ${s1.name}, age: ${s1.age}")
    println()

    s1.name = "이강인"
    s1.age = 20
    println("id: ${s1.id}, name: ${s1.name}, age: ${s1.age}")
}

class Student(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
        get() = field
    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}