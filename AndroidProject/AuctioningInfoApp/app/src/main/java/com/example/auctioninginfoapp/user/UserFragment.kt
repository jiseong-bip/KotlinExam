package com.example.auctioninginfoapp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.auctioninginfoapp.R
import com.example.auctioninginfoapp.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth

class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseAuth.getInstance().currentUser?.let {
            binding.txtUserinfo.text = it.email
        }

        /** 로그아웃 버튼을 클릭하면 */
        binding.btnLogout.setOnClickListener {
            /** 사용자를 로그아웃하고 loginFragment로 이동
            - 사용자를 로그아웃시키려면 signOut() 호출  */
            FirebaseAuth.getInstance().signOut()
            findNavController().navigate(R.id.action_global_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}