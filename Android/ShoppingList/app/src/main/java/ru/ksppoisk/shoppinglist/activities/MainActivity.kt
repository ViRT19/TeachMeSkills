package ru.ksppoisk.shoppinglist.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding
import ru.ksppoisk.shoppinglist.fragments.FragmentManager
import ru.ksppoisk.shoppinglist.fragments.NoteFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog", "Settings")
                }
                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_lst -> {
                    Log.d("MyLog", "Shop List")
                }
                R.id.new_item -> {
                    Log.d("MyLog", "New")
                }
            }
            true
        }
    }
}