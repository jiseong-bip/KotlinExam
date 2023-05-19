package com.example.kotlinbasic.chap07.sec01

/*
* 코틀린에서 클래스 선언은 class 키워드를 사용, 자신의 멤버 속성과 메서드 함수를 가질 수 있음
* 기본적으로 public
* 자바와 달리 소스파일명과 동일하게 작성하지 않아도됨
* 객체 생성시 new키워드가 필요없음
*
*기본 생성자와 하나 이사의 보조 생성자를 지정 가능
*클래스 헤더 안에 기본 생성자를 선언하며, 망니 선언하지 않으면 매개 변수가 없는 기본 생성자를 컴파일러가 자동으로 생성
*기본 생성자는 constructor 키워드 생략 가능/ private 접근자를 사용시에는 constructor 사용해야함
*
* 기본 생성자
* 기본 생성자는 클래스 형태로 선언
* 생성자 매개 변수는 생성자에서만 사용할 수 있는 지역변수
* 생성자 매개 변수를 var/val 로 선언하면, 생성자 매개변수와 이름이 같은 클래스의 멤버 속성으로 정의
*init{}은 생성자를 통해 인스턴스가 만들어질 때 호틀되는 함수
*
*
* */

class Friend constructor(_name: String, _tel: String){
    val name:String
    val tel: String

    init {
        this.name = _name
        this.tel = _tel
        println("멤버 속성이 초기화되었습니다")
    }
}

class Friend2 (_name: String, _tel: String){
    val name:String
    val tel: String

    init {
        this.name = _name
        this.tel = _tel
        println("멤버 속성이 초기화되었습니다")
    }
}
class Friend3(_name: String,_tel: String){
    val name:String = _name
    val tel: String = _tel

    init {
        println("멤버 속성이 초기화되었습니다")
    }
}

class Friend4(val name: String, val tel: String){
    init {
        println("멤버 속성이 초기화되었습니다 ==> name: ${this.name} tel: ${this.tel}")
    }
}

class Friend5(val name: String, val tel: String ="010-1234-0000"){
    init {
        println("멤버 속성이 초기화되었습니다")
    }
}
class Friend6(val name: String, val tel: String, var type: Int = 1){
    init{
        this.type = if(type < 4) type else 4
        println("멤버 속성이 초기화되었습니다")
    }
}

fun main() {
    var obj1: Friend = Friend("손흥민", "010-1231-1223")
    println("이름: ${obj1.name}")
    println("전화번호: ${obj1.tel}")

    var obj2 = Friend2("이강인", "010-1232-4444")
    println("이름: ${obj2.name}")
    println("전화번호: ${obj2.tel}")

    var obj3 = Friend3("봉준호", "010-2133-1111")
    println("이름: ${obj3.name}")
    println("전화번호: ${obj3.tel}")

    var obj4 = Friend4("송강호", "010-4567-3221")
    println("이름: ${obj4.name}")
    println("전화번호: ${obj4.tel}")

    var obj5 = Friend5("아이유")
    println("이름: ${obj5.name}")
    println("전화번호: ${obj5.tel}")

    var obj6 = Friend6("김연아", "010-2331-5678", 2)
    println("이름: ${obj6.name}")
    println("전화번호: ${obj6.tel}")
    println("타입: ${obj6.type}")
}
