package com.example.lesson16_17

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        content()
    }

    fun content() {
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("txt", "Second")
            startActivity(intent2)
        }
        val txt: TextView = findViewById<TextView>(R.id.tv)
        txt.text = intent.getStringExtra("txt")
    }
}