package com.example.testexam01
fun power(a:Int, b:Int) : Int {
    var temp  = a
    when(b){
        0 -> return 1
        1 -> return a
        else -> for (i in 2..b){
            temp *=a
        }
    }
    return temp
}
fun main() {
    val num_list = intArrayOf(1,3,4,2,5,6)
    var answer: Int = 0
    var stringOdd: String = ""
    var stringEven: String = ""
    var odd:Int = 0
    var even:Int = 0
    num_list.indices.forEach{ i ->
        if(num_list[i]%2 == 0){
            stringOdd += num_list[i]
        }else{
            stringEven += num_list[i]
        }
    }
    println(stringOdd.length)
    stringOdd.indices.forEach{ it ->
        odd += (stringOdd[it] - '0') * (power(10, stringOdd.length - it - 1))
    }
    stringEven.indices.forEach{ it ->
        even += (stringEven[it] - '0') * (power(10, stringEven.length - it - 1))
    }

    println(stringOdd)
    println(odd)
    fun solution(n: Int, control: String): Int {
        var answer: Int = n

        control.indices.forEach{
                it -> when{
            control[it] == 'w' -> answer += 1
            control[it] == 's' -> answer -= 1
            control[it] == 'd' -> answer += 10
            control[it] == 'a' -> answer -= 10
        }
        }
        return answer
    }
}