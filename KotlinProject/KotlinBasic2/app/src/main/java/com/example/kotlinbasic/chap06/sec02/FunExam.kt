package com.example.kotlinbasic.chap06.sec02
fun f1() {
    println("f1 함수 호출")

    fun f11() {
        println("f11 함수 호출")
    }
    f11()
}

fun f2(a1: Int, a2:Int) : Int {
    println("f2호출")
    return a1 + a2
}
fun f3(a1: Int, a2: Int ): Int = a1 + a2
fun f4(a1: Int, a2: Int) = a1 + a2

fun f5(a1:Int = 0, a2: Double = 0.0) {
    println("f5호출")
    println("a1 : $a1")
    println("a2 : $a2")
}

fun f6(): Unit {
    println("f6호출 리턴값 없음")
}

fun f7(): Int {
    println("f7호출 리턴값 반환")
    return 100
}

fun f8() {
    println("f8 호출 매개변수 없음")
}

fun f8(a1: Int) {
    println("f8 호출 매개변수 하나 : $a1")
}
fun f8(a1: Double) {
    println("f8호출(매개변수 1개 , 데이터 타입이 다름): $a1")
}

fun f8(a1: Int, a2: Int) {
    println("f8호출(매개변수 2개 , 데이터 타입이 다름): $a1, $a2")
}


fun f9() {
    fun f10()  {
        println("f10 호출")
    }
    println("f9호출")
    f10()

}
fun main() {
    f1()

    var sum = f2(100,200)
    println("sum : $sum")

    sum = f3(100, 200)
    println("f3 호출 \n sum : $sum")

    sum = f4(100, 200)
    println("f4 호출 \n sum : $sum")

    f5()
    f5(100)

    f5(a2=123.12, a1=2000)

    f6()

    var rv1 = f7()
    println("리턴값 rv1 : $rv1")

    f8()
    f8(100)
    f8(100.12)
    f8(100,200)

    f9()
}