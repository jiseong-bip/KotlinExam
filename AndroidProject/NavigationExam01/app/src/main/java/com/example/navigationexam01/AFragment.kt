package com.example.navigationexam01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationexam01.databinding.FragmentABinding

class AFragment : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    /** 프래그먼트 뷰 생성 */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** Inflate the layout for this fragment */
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding.root

        /** btnAToB 버튼 클릭시 이벤트 처리 */
        binding.btnAToB.setOnClickListener {
            /** Fragment에서 NavController를 가져와 navigate()를 이용하여 인수로 받은 목적지로 이동 */
            findNavController().navigate(R.id.action_AFragment_to_BFragment)
        }

        /** btnAToC 버튼 클릭시 이벤트 처리 */
        binding.btnAToC.setOnClickListener {
            /** Fragment에서 NavController를 가져와 navigate()를 이용하여 인수로 받은 목적지로 이동 */
            findNavController().navigate(R.id.action_AFragment_to_CFragment)
        }
        return view
    }//end of onCreateView()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}