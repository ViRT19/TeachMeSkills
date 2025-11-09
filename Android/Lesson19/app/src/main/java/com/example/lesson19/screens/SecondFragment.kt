package com.example.lesson19.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson19.MAIN
import com.example.lesson19.NAME
import com.example.lesson19.R
import com.example.lesson19.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.editText.text = NAME
        binding.button2.setOnClickListener {
            NAME = binding.editText.text.toString()
            MAIN.navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}