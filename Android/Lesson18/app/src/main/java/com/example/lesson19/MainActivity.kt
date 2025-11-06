package com.example.lesson19

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, BlankFragment.newInstance())
            .commit()

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, BlankFragment2.newInstance())
                .commit()
            btn.text = "Третий фрагмент"

            btn.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, BlankFragment3.newInstance())
                    .commit()
                btn.visibility = View.INVISIBLE
            }
        }
    }
}