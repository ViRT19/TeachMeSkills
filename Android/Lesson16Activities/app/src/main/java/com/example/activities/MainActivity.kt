package com.example.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val logTag = "LogTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(logTag, "Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(logTag, "Activity onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(logTag, "Activity onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(logTag, "Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(logTag, "Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(logTag, "Activity onDestroy")
    }

}