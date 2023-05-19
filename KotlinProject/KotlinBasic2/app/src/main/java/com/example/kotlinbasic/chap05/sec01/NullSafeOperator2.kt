package com.example.kotlinbasic.chap05.sec01

fun main() {
    val president = Employee("김대표", null)
    val director = Employee("김부장", president)

    println(managerInfo(president))
    println(managerInfo(director))
}

class Employee(val name: String, val manager:Employee?)

fun managerInfo(employee: Employee): String? = employee.manager?.name