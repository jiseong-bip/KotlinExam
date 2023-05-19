package com.example.kotlinbasic.chap07.sec02

fun main() {
    val sony = Friend()
    println("#1: ${sony.name}, ${sony.tel}, ${sony.type}")

    sony.name = "손흥민"
    sony.tel = "010-2222-3333"
    sony.type = 1
    println("#2: ${sony.name}, ${sony.tel}, ${sony.type}")
}

class Friend {
    var name: String? = null
        get() {
            println("#3: name 속성 Getter 호출")
            return if(field != null) field else "이름 없음"
        }
        set(value) {
            field = value
            println("#4: name 속성 Setter 호출")
        }

    var tel: String? = null
        get() {
            println("#5: tel 속성 Getter 호출")
            return if(field != null) field else "이름 없음"
        }
        set(value) {
            field = value
            println("#6 tel 속성 Setter 호출")
        }

    var type: Int = 4
        get() {
            println("#7: type 속성 Getter 호출")
            return field
        }
        set(value: Int) {
            field = if (value < 4) value else 4
            println("#8 type 속성 Setter 호출")
        }
}