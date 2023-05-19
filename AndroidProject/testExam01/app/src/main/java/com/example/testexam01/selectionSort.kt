package com.example.testexam01

fun main() {
    fun selectionSort(arr: IntArray): IntArray {
        val result: IntArray = arr.clone()

        for (i in 0 until result.size - 1) {
            var minIndex = i

            for (j in i + 1 until result.size) {
                if (result[j] < result[minIndex]) {
                    minIndex = j
                }
            }

            val temp = result[i]
            result[i] = result[minIndex]
            result[minIndex] = temp
        }

        return result
    }
    val arr = intArrayOf(8,2,3,1,6,7,9)
    print(selectionSort(arr).contentToString())
}