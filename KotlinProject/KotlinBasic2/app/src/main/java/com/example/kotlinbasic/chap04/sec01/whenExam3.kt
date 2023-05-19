package com.example.kotlinbasic.chap04.sec01

fun main() {
    print("Enter the score: ")
    var score: Double? = readLine()?.toDoubleOrNull()
    var grade: Char = 'F'

    if(score != null) {
        when(score) {
            in 90.0..100.0-> grade = 'A'
            in 80.0..89.9-> grade = 'B'
            in 70.0..79.9-> grade = 'C'
            in 60.0..69.0-> grade = 'D'
            in 0.0..59.9-> grade = 'F'
        }
    }

    println("Score: $score, Grade: $grade")
}