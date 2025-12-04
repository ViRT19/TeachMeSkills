package ru.ksppoisk.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.activities.MainApp
import ru.ksppoisk.shoppinglist.databinding.FragmentNoteBinding
import ru.ksppoisk.shoppinglist.db.MainViewModel

class NoteFragment : BaseFragment() {
    private lateinit var binding: FragmentNoteBinding
    private val mainViewModel: MainViewModel by activityViewModels() {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClickNew() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}