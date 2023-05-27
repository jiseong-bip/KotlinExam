package com.example.fragmentexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.fragmentexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "MainActivity - onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onInitBottomNav()

    }

    private fun onInitBottomNav() {
        binding.bottomNav.run {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.menu_home-> {
                        onReplaceFragement(FragmentHome())
                        Log.d(TAG, "MainActivity - Home 메뉴 클릭")
                    }
                    R.id.menu_list-> {
                        onReplaceFragement(FragmentList())
                        Log.d(TAG, "MainActivity - Home 메뉴 클릭")
                    }
                    R.id.menu_profile-> {
                        onReplaceFragement(FragmentProfile())
                        Log.d(TAG, "MainActivity - Home 메뉴 클릭")
                    }
                }
                true
            }
            //기본 메뉴로 설정
           selectedItemId = R.id.menu_home
        }
    }

    private fun onReplaceFragement(fragment: Fragment) {
        /*
        * transaction 시작 : supportFragmentManager.beginTransaction()
        * fragment transaction : replace(R.id.fragmentContainerView, fragment)
        * transaction 종료 : commit()
        * */
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.fragmentContainerView, fragment)
        }.commit()

    }

    companion object {
        const val TAG: String = "로그"
    }
}