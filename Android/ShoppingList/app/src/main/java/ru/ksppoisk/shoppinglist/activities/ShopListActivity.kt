package ru.ksppoisk.shoppinglist.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding
import ru.ksppoisk.shoppinglist.databinding.ActivityShopListBinding
import ru.ksppoisk.shoppinglist.db.MainViewModel
import ru.ksppoisk.shoppinglist.entities.NoteItem
import ru.ksppoisk.shoppinglist.entities.ShopListNameItem
import ru.ksppoisk.shoppinglist.fragments.NoteFragment.Companion.NEW_NOTE_KEY

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding
    private var shopListNameItem: ShopListNameItem? = null
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
        init()
    }

    /*

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            it.data?.getSerializableExtra(NEW_NOTE_KEY, NoteItem::class.java)
        } else {
            it.data?.getSerializableExtra(NEW_NOTE_KEY) as NoteItem
        }

    */
    private fun init() {
        shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME) as ShopListNameItem
        binding.tvTest.text = shopListNameItem?.name
    }

    companion object {
        const val SHOP_LIST_NAME = "shop_list_name"
    }
}