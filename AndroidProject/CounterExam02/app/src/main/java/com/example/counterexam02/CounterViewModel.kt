package com.example.counterexam02

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.temporal.TemporalAmount

class CounterViewModel : ViewModel() {
    /* 라이브 데이터 선언(counterML을 MutableLiveData<Int> 형으로 선언) */
    private val counterML = MutableLiveData<Int>().apply {
        Log.d(MainActivity.TAG, "CounterViewModel 초기화")

        setValue(0)
    }

    fun getCounter() : LiveData<Int> = counterML

    fun increaseOrDecreaseValue(amount: Int) {
        Log.d(MainActivity.TAG, "increaseOrDecreaseValue() called - 라이브 데이터 변경 발생")
        //현재 counterML값을 변수에 저장
        val originValue = counterML.value ?: 0
        //라이브데이터 변경
        counterML.postValue(originValue + amount)
    }
}