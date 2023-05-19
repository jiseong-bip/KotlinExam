package com.example.kotlinbasic.chap05.sec01

class Address(val streetAddress: String, val zipCode: Int)
class Company(val companyName: String, val address: Address?)
class Person(val name: String, val company: Company?)
fun main() {
    val address = Address("경기 성남시 분당구 정자일로 95", 13561)
    val naver = Company("네이버", address)
    val sony = Person("손흥민", naver)
}