package com.example.kotlinbasic.chap09.sec03

data class Customer( val name : String, val age: Int, val tel: String) {
    init {
        println("멤버 속성이 초기화 되었습니다.")
    }

    var nationality: String = "korea"
    constructor(name : String, age:Int, tel: String, _nationality: String) : this(name, age, tel) {
        nationality = _nationality
    }
}

fun main() {
    var obj1 = Customer("손흥민", 28, "010-123-123")
    var obj2 = Customer("이강인", 19, "010-1423-123")
    var obj3 = Customer("봉준호", 52, "010-663-1773")

    println("obj1: $obj1")
    println("obj2: $obj2")
    println("obj3: $obj3")

    println("${obj3.name} 감독의 국적은 ${obj3.nationality} 입니다")

    println(obj1==obj2)

    println(obj1.hashCode() == obj2.hashCode())
    println("obj1.hashcode() : ${obj1.hashCode()} == obj2.hashcode() : ${obj2.hashCode()}")

    val obj4 = obj1.copy(tel = "010-7777-1231")
    println(obj4)
    println(obj4==obj1)
    println(obj4===obj1)

    val (fName, fAge, ftel) = obj1
    println("$fName, $fAge, $ftel")

    val customerList = listOf(obj1, obj2, obj3, obj4)
    for ((name, age, tel) in customerList)
    {
        println("name: $name, age: $age, tel: $tel")
    }

    println("===================")

    val lamdaCustom = {
        (name, age, tel) : Customer ->
            println("name: $name, age: $age, tel: $tel")
    }

    for (obj in customerList) {
        lamdaCustom(obj)
    }

    println("=================")

    var obj5 = Customer("김민재", 27, "010-1321-3325")
    var obj6 = Customer("김혜인", 17, "010-663-2496")
    var obj7 = Customer("최민아", 21, "010-9863-5673")

    val manager = CustomerManger()
    manager.joinCustomer(obj1)
    manager.joinCustomer(obj2)
    manager.joinCustomer(obj3)
    manager.joinCustomer(obj5)
    manager.joinCustomer(obj6)
    manager.joinCustomer(obj7)

    manager.printAllCustomer()
}

class CustomerManger {
    private val customList = ArrayList<Customer>()

    fun joinCustomer(customer: Customer){
        when {
            customer.age < 20 -> {
                println("나이가 20세 미만입니다! : ${customer.name} - ${customer.age}")
                return
            }
            else -> {
                println("나이가 20세 이상입니다 : ${customer.name} - ${customer.age}")
            }
        }
        this.customList.add(customer)
    }

    fun printAllCustomer() {
        println("=".repeat(50))
        println("    === 등록 고객 리스트 (총 ${customList.size})명 ===")
        println("=".repeat(50))

        this.customList.forEach{
            println(it)
        }
    }
}