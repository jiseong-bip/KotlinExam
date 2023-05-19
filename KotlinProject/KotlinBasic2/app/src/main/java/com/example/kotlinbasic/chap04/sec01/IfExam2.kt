package com.example.kotlinbasic.chap04.sec01

import com.example.kotlinbasic.chap03.sec01.Score

fun main() {
    print("Enter the score")
    var score: Double? = readLine()?.toDoubleOrNull()
    println(score)

    var grade: Char = 'F'

    if (score != null) {
        if (score >= 90) {
            grade = 'A'
        } else if (score >= 80 && score <= 89.9) {
            grade = 'B'
        } else if (score >= 70 && score <= 79.9) {
            grade = 'C'
        } else if (score >= 60 && score <= 69.9) {
            grade = 'D'
        }
    }
    println("Score: ${score}, Grade: $grade")

    print("Enter the score")

    var score2: Double? = readLine()!!.toDoubleOrNull()
    println(score2)

    grade = 'F'

    if (score2 != null) {
        if (score2 >= 90) {
            grade = 'A'
        } else if (score2 in 80.0..89.0) {
            grade = 'B'
        } else if (score2 in 70.0..79.0) {
            grade = 'C'
        } else if (score2 in 60.0..69.0) {
            grade = 'D'
        }
    }
    println("Score2: ${score2}, Grade: $grade")
}