package com.example.kotlinbasic.chap07.sec01

class Professor(_name: String, _age: Int) {
    var name: String = _name
    var age: Int = _age

    init{
        this.name = if(_name.isNotEmpty() && _name.isNotBlank()) _name.uppercase() else "GUEST"
    }

    var major: String = "컴퓨터공학과"
    constructor(_name: String,  _age: Int, _major: String) : this(_name, _age) {
        this.major = _major
    }

    var popular: Double = 70.0
    constructor(_name: String,_age: Int,_major: String, _popular: Double) : this(_name,_age, _major) {
        this.popular = _popular
    }

    fun showInfo() {
        var info = """
            =======교수정보=======
            - 이름 : $name ${if (this.popular >= 80.0) "**우수 교수 **" else ""}
            - 나이 : $age
            - 전공 : $major
            - 평가 : $popular
        """.trimIndent()
        println(info)
    }
}

fun main() {
    val p1 = Professor("lee", 41)
    val p2 = Professor("kang", 37, "인공지능")
    val p3 = Professor("kim", 47, "데이터베이스")
    val p4 = Professor("kim", 57, "빅데이터", 87.0)

    val profs: List<Professor> = arrayListOf(p1,p2,p3,p4)

    for(prof in profs) {
        prof.showInfo()
    }
}