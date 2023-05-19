package com.example.navigationexam01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigationexam01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "로그"
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    /** 네비게이션 navController 선언 */
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** NavHostFragment 참조 */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        /** navController를 navHostFragment에서 가져오기 */
        navController = navHostFragment.navController

        /** Destination이 바뀔 때 Log 출력 */
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d(TAG, "${destination.label}")
        }
    }
}