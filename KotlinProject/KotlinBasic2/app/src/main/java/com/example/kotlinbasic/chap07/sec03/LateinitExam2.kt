package com.example.kotlinbasic.chap07.sec03

class Student {
    private lateinit var name: String

    fun initName(_name:String) {
        this.name = _name
    }

    fun printName(): String = this.name


    fun initCheck() {
        /*
        * 속성 초기화 여부 check
        * 더블 콜론 (::) => 프로퍼티 참조(리플렉션)
        * 리플렉션이란 : 클래스, 함수, 프로퍼디에 대한 래퍼런스를 런타임 때 동적으로 분석해 내는 기법
        * 속성앞에 더블콜론을 명시하면 속성을 객체로 액세스하여 객체에 대한 속성을 참조할 수 있
  (     * ::name.get() : name의 게터 호출
        */
        if (!::name.isInitialized) println("not initialized") else println("initialized: ${::name.get()}")
    }
}

fun main() {
    val sony = Student()

    sony.initCheck()

    sony.initName("손흥민")

    println("name: ${sony.printName()}")

    sony.initCheck()
}