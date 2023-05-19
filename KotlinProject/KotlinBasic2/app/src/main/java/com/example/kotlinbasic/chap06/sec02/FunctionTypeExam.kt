package com.example.kotlinbasic.chap06.sec01

fun main() {
    println(isOdd(7))
    println(isOdd2(7))
    println(isOdd3(7))
    println(isOdd4(7))
    println(isOdd5(7))
    println(isOdd6(7))
    printName("sony")
    println(highOrderFunc({x, y -> x + y}, 10, 10))

    println(calculate(5, 10) { a, b -> a+b})
    println(calculate2(5, 10) { a, b -> a+b})

    val add = getOperation("+")
    val result = add(5, 10)
    println("result: $result")
}

fun isOdd(x:Int): Boolean {
    return x % 2 != 0
}

val isOdd2: (Int) -> Boolean = fun(x: Int): Boolean {return  x %2 != 0}
val isOdd3: (Int) -> Boolean = fun(x) =  x%2 != 0
val isOdd4 = fun(x: Int): Boolean = x % 2 != 0
val isOdd5 = fun(x: Int) = x%2 != 0

val isOdd6: (Int) -> Boolean = {x -> x%2 != 0}

val printName: (String)-> Unit = fun(name){
    println("My name is '$name'!")
}

fun highOrderFunc(sum:(Int, Int) -> Int, x: Int, y: Int): Int = sum(x,y)

fun calculate(a:Int, b:Int, operation: (Int, Int) -> Int): Int {
    return operation(a,b)
}

fun calculate2(a: Int, b: Int, operation: (Int, Int)-> Int): Int = operation(a,b)

fun getOperation(operation: String): (Int, Int) -> Int {
    return when (operation){
        "+" -> {a, b -> a+b}
        "-" -> {a, b -> a-b}
        "*" -> {a, b -> a*b}
        "/" -> {a, b -> a/b}
        else -> throw java.lang.IllegalArgumentException("Invalid operation")
    }
}
