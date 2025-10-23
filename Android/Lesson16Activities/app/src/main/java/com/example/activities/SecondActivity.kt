package com.example.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(Object.logTag, "SecondActivity onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickToMain (view: View) {
        val intent = Intent(this, MainActivity::class.java)
        Object.countSwitchMyActivity ++
        intent.putExtra(Object.keyOfCount, Object.countSwitchMyActivity)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i(Object.logTag, "SecondActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Object.logTag, "SecondActivity onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Object.logTag, "SecondActivity onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Object.logTag, "SecondActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Object.logTag, "SecondActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Object.logTag, "SecondActivity onDestroy")
    }

}