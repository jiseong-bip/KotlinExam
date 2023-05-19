package com.example.testexam01

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        println(arr.contentToString())
        val pivotIndex = partition(arr, low, high)
        println("Pivot: ${arr[pivotIndex]}")
        println("Partitioned Array: ${arr.sliceArray(low..high).contentToString()}")
        println("Array : ${arr.contentToString()}")
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            //println("swap1 : ${arr[i]}, ${arr[j]}")
            swap(arr, i, j)
        }
    }
    //println("swap2 : ${arr[i+1]}, ${arr[high]}")
    swap(arr, i + 1, high)
    return i + 1
}

fun swap(arr: IntArray, i: Int, j: Int) {
    println("swap ${arr[i]}, ${arr[j]}")
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun main() {
    val arr = intArrayOf(8, 12, 2, 3, 1, 6, 5, 7, 10, 9)
    quickSort(arr, 0, arr.size - 1)

    println("Sorted Array:")
    for (num in arr) {
        print(num)
    }
}
