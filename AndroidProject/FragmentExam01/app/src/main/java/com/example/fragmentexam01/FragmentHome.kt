package com.example.fragmentexam01

import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexam01.MainActivity.Companion.TAG
import com.example.fragmentexam01.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    /*
    * fragment에서 viewbinding을 nullable type으로 처리하는 이유
    * onDestroyView()를 통해서 null처리가 필요하기 때문
    * */
    private var _binding: FragmentHomeBinding? = null
    /*
        * Used to prevent null exception and memory leak
        * _binding이 nullabltype으로 선언되어 있기 때문에 잠재적으로 null exception이 발생할 여지가 있음
        *null type이 아님을 알려줌(강제화)
     */
    private val binding get() = _binding!!

    //프래그먼트가 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragement - onCreate() called")
    }
    //프래그먼트가 맥티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach() called")
    }
    //프래그먼트가 뷰를 생성할(inflate)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "HomeFragment - onCreateView() called")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}