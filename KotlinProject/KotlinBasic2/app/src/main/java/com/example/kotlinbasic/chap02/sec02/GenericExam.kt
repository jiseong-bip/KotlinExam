package com.example.kotlinbasic.chap02.sec02

fun main() {
    val q1 = Question<String>("안드로이드 앱 제작을 위한 공식 통합 개발 환경?", "안드로이드 스튜디오")
    val q2 = Question<Boolean>("코틀린은 JetBrains사에서 만든 JVM 기반 언어이다. (true of false)", true)
    val q3 = Question<Int>("안드로이드 Ver13의 API Level은?", 33)
}
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean
)

class NumericQuestion(
    val questionText: String,
    val answer: Int
)

class Question<T>(
    val questionText: String,
    val answer: T
)
