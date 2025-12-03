package ru.ksppoisk.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.databinding.FragmentNoteBinding

class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClickNew() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}