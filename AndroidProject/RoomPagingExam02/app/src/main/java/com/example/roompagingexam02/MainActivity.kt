package com.example.roompagingexam02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roompagingexam02.database.AppDatabase
import com.example.roompagingexam02.database.NoteRepository
import com.example.roompagingexam02.database.NoteViewModel
import com.example.roompagingexam02.databinding.ActivityMainBinding
import com.example.roompagingexam02.dialog.NoteCreateDialog
import com.example.roompagingexam02.list.NoteAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    /** noteDao 가져오기 */
    val noteDao by lazy { AppDatabase.getDatabase(this).noteDao() }

    /** CoroutineContext 설정 */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** NoteViewModel 가져오기 */
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        /** noteViewModel.initialize() 함수 호출(NoteViewModel 초기화) */
        noteViewModel.initialize(NoteRepository(noteDao))

        /** noteAdapter 생성 및 deleteCallback(it)을 받아 처리할 람다식 작성
         * - NoteAdpater에서 삭제 버튼을 클릭하면 삭제를 자신의 부모인 MainAcitivity에
         *   deleteCallback(it)을 통해 위임함
         * - 따라서 deleteCallback(it)을 받아 노트를 삭제할 콜백을 람다식으로 작성
         */
        val noteAdapter = NoteAdapter(noteDao) { note ->
            Log.d("TAG", "MainActivity-delete")

            /** 노트 Delete */

            /** 노트 Delete */

            /** 노트 Delete */

            /** 노트 Delete */
            launch(coroutineContext + Dispatchers.IO) {
                noteDao.deleteNots(note)
            }
        }

        /** RecycleView Initialize
         * 1. 페이징된 데이터를 표시할 RecyclerView에 noteAdapter 객체 설정
         * 2. RecyclerView layoutManager 설정
         * */
        binding.recycleNote.adapter = noteAdapter
        binding.recycleNote.layoutManager = LinearLayoutManager(this)

        /** Observe the PagingData and submit it to the adapter
         *  noteViewModel.getItems()에서 최신의 새로운 데이터(PagingData)가 전달되면
         *  람다식의 noteAdapter.submitData() 메서드를 이용하여 NoteAdapter에 전달
         *  - Flow에서 발행한 스트림 데이터는 collect의 action 파라미터에 의해 소비
         *  - pagingData를 submit하면 NoteAdapter 의 DIFF_CALLBACK은
         *   기존 pagingData와 비교하여 리사이클러뷰를 새로운 페이지로 갱신
         * */
        lifecycleScope.launch {
            noteViewModel.getItems().collectLatest { pagingData ->
                noteAdapter.submitData(pagingData)
            }
        }

        /** "+"(fab_add_note) 버튼을 클릭하면 NoteCreateDialog 출력  */
        binding.fabAddNote.setOnClickListener {
            Log.d("TAG", "MainActivity-NoteCreateDialog()")
            NoteCreateDialog().show(supportFragmentManager, null)
        }
    }//end of onCreate
}