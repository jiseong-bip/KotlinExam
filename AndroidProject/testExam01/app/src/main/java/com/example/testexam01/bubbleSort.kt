package com.example.testexam01
fun BubbleSort(array: IntArray): IntArray {
    var result: IntArray = array.clone()
    for (i in 0 until array.size){
        var biggerArr = 0
        for (j in 1 until array.size - i){
            if (result[j-1] > result[j]){
                biggerArr = result[j-1]
                result[j-1] = result[j]
                result[j] = biggerArr
            }
            print("${result.contentToString()} -> ")
        }
    }
    return result
}
fun main() {
    val arr = intArrayOf(8,2,3,1,6,7,9)
    print("버블 정렬 : ")
    print(BubbleSort(arr).contentToString())
}