package com.example.auctioninginfoapp.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.auctioninginfoapp.R
import com.example.auctioninginfoapp.databinding.FragmentRegisterBinding
import com.example.freshauctionapp.util.hideKeyboard
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    /** FirebaseAuth 객체의 공유 인스턴스를 가져오기 */
    val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_register 뷰 inflate
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** 가입하기 버튼을 클릭한 경우 */
        binding.btnRegister.setOnClickListener {
            //id, pw, pw_firm 값 가져오기
            val id = binding.fieldRegisterId.text.toString()
            val pw = binding.fieldRegisterPw.text.toString()
            val pw_firm = binding.fieldRegisterPwConfirm.text.toString()

            /** id, pw, pw_firm 입력 여부 확인 */
            when {
                id.isEmpty() -> Toast.makeText(requireContext(), "아이디를 입력하세요.", Toast.LENGTH_LONG)
                    .show()
                pw_firm.isEmpty() || pw.isEmpty() -> Toast.makeText(
                    requireContext(),
                    "패스워드를 입력하세요.",
                    Toast.LENGTH_LONG
                ).show()
                pw_firm != pw -> Toast.makeText(
                    requireContext(),
                    "비밀번호가 일치하지 않습니다.",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    //id, pw, pw_firm 입력값이 정상이면
                    binding.registerLoader.visibility = View.VISIBLE

                    /** 신규 사용자의 이메일 주소와 비밀번호를 createUserWithEmailAndPassword에 전달하여
                    신규 계정을 생성하고, searchFragment로 이동
                    - 실패한 경우 에러 메시지 출력
                     */
                    firebaseAuth.createUserWithEmailAndPassword(id, pw)
                        .addOnCompleteListener { task ->
                            /** 성공한 경우*/
                            task.addOnSuccessListener {
                                //입력 필드 초기화
                                binding.fieldRegisterId.text = null
                                binding.fieldRegisterPw.text = null
                                binding.fieldRegisterPwConfirm.text = null
                                binding.registerLoader.visibility = View.GONE

                                hideKeyboard()//소프트 키보드 숨기기
                                findNavController().navigate(R.id.action_global_searchFragment)
                            }
                            /** 실패한 경우*/
                            task.addOnFailureListener {
                                binding.registerLoader.visibility = View.GONE
                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }//end of firebaseAuth.createUserWithEmailAndPassword.addOnCompleteListener
                }//end of when-else
            }//end of when
        }//end of view.btn_register.setOnClickListener
    }//end of onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}//end of RegisterFragment