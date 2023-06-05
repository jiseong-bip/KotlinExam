package com.example.auctioninginfoapp.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.auctioninginfoapp.database.DatabaseModule
import com.example.auctioninginfoapp.databinding.FragmentSaveBinding
import com.example.auctioninginfoapp.result.SaveAdpater
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SaveFragment : Fragment() {
    private var _binding: FragmentSaveBinding? = null
    private val binding get() = _binding!!

    /** DatabaseModule.getDatabase(싱글톤)를 이용하여 데이터베이스를 가져오기.*/
    private val database by lazy {
        DatabaseModule.getDatabase(requireContext())
    }

    /** saveAdapter 생성 */
    private val saveAdapter by lazy { SaveAdpater() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_save 뷰 inflate
        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //리사이클러뷰에 어댑터 및 LayoutManager 설정
        binding.listSave.layoutManager = LinearLayoutManager(requireContext())
        binding.listSave.adapter = saveAdapter

        /** 전달받은 bundle 객체에서 SAVE_ID를 추출
        - 저장된 DB에서 saveId로 검색하여 출력   */
        arguments?.getLong("SAVE_ID")?.let { saveId ->
            /** DB에서 saveId로 쿼리하여 PagingData 객체(LiveData) 생성 */
            val pagingData = Pager(
                PagingConfig(20), 1,
                database.freshDao().loadFreshData(saveId = saveId).asPagingSourceFactory(Dispatchers.IO)
            )

            /** LiveData 형태인 PagingData를 observe */
            pagingData.liveData.observe(viewLifecycleOwner) {
                /** saveAdapter(PagingDataAdapter)에 pagingData를 submit - 리사이클러뷰에 바인딩 해줄 것을 요청
                - suspend fun submitData(pagingData: PagingData<T>) {differ.submitData(pagingData)}
                - submitData() 함수가 suspend 함수이기 때문에 코루틴을 통해 비동기 처리   */
                lifecycleScope.launch {
                    saveAdapter.submitData(it)
                }
            }
        }
    }//end of onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}