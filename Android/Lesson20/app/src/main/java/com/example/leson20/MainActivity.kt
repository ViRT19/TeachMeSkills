package com.example.leson20

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leson20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var itemsCount = 0

        val listOfItems: MutableList<String> = mutableListOf()
/*        val listOfItems: MutableList<String> = mutableListOf("First", "Second", "Third")
        listOfItems.add("Fourth")
        if (listOfItems.size > 0)
            binding.textNullList.visibility = TextView.INVISIBLE
*/
        binding.recycler.adapter = MyAdapter(listOfItems)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.floatingAddButton.setOnClickListener {
            itemsCount++
            listOfItems.add(itemsCount.toString())
            binding.recycler.adapter?.notifyItemInserted(itemsCount)
            binding.textNullList.visibility = TextView.INVISIBLE
        }

    }
}