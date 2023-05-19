package com.example.navigationexam01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationexam01.databinding.FragmentDBinding

class DFragment : Fragment() {
    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnDToA.setOnClickListener {
            findNavController().navigate(R.id.action_DFragment_to_AFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}