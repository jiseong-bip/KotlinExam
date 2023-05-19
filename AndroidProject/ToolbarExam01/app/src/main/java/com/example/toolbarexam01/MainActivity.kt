package com.example.toolbarexam01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.toolbarexam01.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbar.title = "Toolbar"
        binding.toolbar.setTitleTextColor(Color.WHITE)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                Snackbar.make(binding.root, "Click the Home Button", Snackbar.LENGTH_LONG).show()
            }
            R.id.search -> {
                Snackbar.make(binding.root, "Click the search Button", Snackbar.LENGTH_LONG).show()
            }
            R.id.save -> {
                Snackbar.make(binding.root, "Click the save Button", Snackbar.LENGTH_LONG).show()
            }
            R.id.delete -> {
                Snackbar.make(binding.root, "Click the delete Button", Snackbar.LENGTH_LONG).show()
            }
        }
        return true
    }
}