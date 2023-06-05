package com.example.counterexam02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.counterexam02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val  TAG: String = "로그"
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    /* ViewModel 가져오기 -> viewmodel 인스턴스 생성
       - ViewModelProvider(context).get(ViewModel class) */
    private val viewModel by lazy {
        //MainActivity lifecycle을 따르는 ViewModel 생성
        ViewModelProvider(this).get(CounterViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val counterObserver = Observer<Int> {
            binding.counterTv.text = it.toString()
        }
        /*
        * LiveData is observed using the observe() method of LiveData
            - observe(LifecycleOwner, Observe)
            - ViewModel이 가지고 있는 LiveData(ounterML)를 옵저버가 관찰
            - 변화가 생기면 자동 갱신
        */
        viewModel.getCounter().observe(this, counterObserver)

        init()
    }
    fun init() {
        with(binding) {
            binding.fabAdd.setOnClickListener{
                viewModel.increaseOrDecreaseValue(1)
            }
            binding.fabRemove.setOnClickListener{
                viewModel.increaseOrDecreaseValue(-1)
            }
        }
    }
}