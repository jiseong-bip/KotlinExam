package com.example.kotlinbasic.chap07.sec01

fun main() {
    var obj1 = Custom("손흥민")
    println(obj1.name)
    println(obj1.tel)
    println(obj1.type)
    println("========")

    var obj2 = Custom("이간인", "010-2123-5665")
    println(obj2.name)
    println(obj2.tel)
    println(obj2.type)
    println("========")

    var obj3 = Custom("봉준호", "010-1223-1233")
    println(obj3.name)
    println(obj3.tel)
    println(obj3.type)
    println("========")

    var obj4 = Custom2("송강호")
    println(obj4.name)
    println(obj4.tel)
    println(obj4.type)
    println("========")

    var obj5 = Custom2("박소담", "010-2132-0000", 7)
    println(obj5.name)
    println(obj5.tel)
    println(obj5.type)
    println("========")
}

class Custom(_name: String) {
    var name: String = _name
    var tel: String = ""
    var type: Int = 0

    init {
        println("기본 생성자 초기화")
    }

    constructor(_name: String, _tel: String) : this(_name){
        this.tel = _tel
        println("보조  생성자(매개변수 2개) 호출")
    }

    constructor(_name: String, _tel: String, _type: Int) : this(_name, _tel) {
        this.type = if(_type < 4) _type else 4

        println("보조 생성자(매개변수 3개) 호출")
    }
}

class Custom2{
    var name:String
    var tel: String
    var type: Int

    constructor(_name: String) : this(_name, "", 2)
    constructor(_name: String, _tel: String, _type: Int = 4) {
        this.name = _name
        this.tel = _tel
        this.type = if(_type < 4) _type else 4
    }
}