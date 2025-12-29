package ru.ksppoisk.shoppinglist.activities

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    private lateinit var saveItem: MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop_list_menu, menu)
        saveItem = menu?.findItem(R.id.save_item)!!
        val newItem = menu.findItem(R.id.new_item)
        newItem.setOnActionExpandListener(expandActionView())
        saveItem.isVisible = false
        return true
    }

    private fun expandActionView(): MenuItem.OnActionExpandListener {
        return object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                saveItem.isVisible = false
                invalidateOptionsMenu()
                return true
            }

            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                saveItem.isVisible = true
                return true
            }

        }
    }

    private fun init() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME, ShopListNameItem::class.java)
        else
            shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME) as ShopListNameItem
        binding.tvTest.text = shopListNameItem?.name
    }

    companion object {
        const val SHOP_LIST_NAME = "shop_list_name"
    }
}