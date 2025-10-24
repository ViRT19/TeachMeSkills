package com.example.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activities.Object.countSwitchMyActivity

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bindingClass = MainActivity
        Log.i(Object.logTag, "MainActivity onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }
        val tv: TextView = findViewById(R.id.countOfSwitchesNumber)
        tv.text = Object.countSwitchMyActivity.toString()
    }

    fun onClickToSecond(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        Object.countSwitchMyActivity ++
    }

    override fun onStart() {
        super.onStart()
        Log.i(Object.logTag, "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Object.logTag, "MainActivity onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Object.logTag, "MainActivity onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Object.logTag, "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Object.logTag, "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Object.logTag, "MainActivity onDestroy")
    }

}