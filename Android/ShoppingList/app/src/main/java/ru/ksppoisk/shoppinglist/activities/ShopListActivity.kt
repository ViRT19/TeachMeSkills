package ru.ksppoisk.shoppinglist.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding
import ru.ksppoisk.shoppinglist.databinding.ActivityShopListBinding
import ru.ksppoisk.shoppinglist.db.MainViewModel
import ru.ksppoisk.shoppinglist.db.ShopListItemAdapter
import ru.ksppoisk.shoppinglist.dialogs.EditListItemDialog
import ru.ksppoisk.shoppinglist.entities.LibraryItem
import ru.ksppoisk.shoppinglist.entities.NoteItem
import ru.ksppoisk.shoppinglist.entities.ShopListItem
import ru.ksppoisk.shoppinglist.entities.ShopListNameItem
import ru.ksppoisk.shoppinglist.fragments.NoteFragment.Companion.NEW_NOTE_KEY
import ru.ksppoisk.shoppinglist.utils.ShareHelper

class ShopListActivity : AppCompatActivity(), ShopListItemAdapter.Listener {
    private lateinit var binding: ActivityShopListBinding
    private lateinit var defPref: SharedPreferences
    private var shopListNameItem: ShopListNameItem? = null
    private lateinit var saveItem: MenuItem
    private var edItem: EditText? = null
    private var adapter: ShopListItemAdapter? = null
    private lateinit var textWatcher: TextWatcher
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        @Suppress("DEPRECATION")
        defPref = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(getSelectedTheme())
        setContentView(binding.root)
        init()
        initRcView()
        listItemObserver()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop_list_menu, menu)
        saveItem = menu?.findItem(R.id.save_item)!!
        val newItem = menu.findItem(R.id.new_item)
        edItem = newItem.actionView?.findViewById(R.id.edNewShopItem) as EditText
        newItem.setOnActionExpandListener(expandActionView())
        saveItem.isVisible = false
        textWatcher = textWatcher()
        return true
    }

    private fun textWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("MyLog", "On Text Changed: $s")
                mainViewModel.getAllLibraryItems("%$s%")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_item -> addNewShopItem(edItem?.text.toString())
            R.id.delete_list -> {
                mainViewModel.deleteShopList(shopListNameItem?.id!!, true)
                finish()
            }

            R.id.clear_list ->
                mainViewModel.deleteShopList(shopListNameItem?.id!!, false)

            R.id.share_list ->
                startActivity(
                    Intent.createChooser(
                        ShareHelper.shareShopList(adapter?.currentList!!, shopListNameItem?.name!!),
                        "Share by"
                    )
                )
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addNewShopItem(name: String) {
        if (name.isEmpty()) return
        val item = ShopListItem(
            null,
            name,
            "",
            false,
            shopListNameItem?.id!!,
            0
        )
        edItem?.setText("")
        mainViewModel.insertShopItem(item)
    }

    private fun listItemObserver() {
        mainViewModel.getAllItemsFromList(shopListNameItem?.id!!).observe(this, {
            adapter?.submitList(it)
            binding.tvEmpty.visibility = if (it.isEmpty())
                View.VISIBLE
            else
                View.GONE
        })
    }

    private fun libraryItemObserver() {
        mainViewModel.libraryItems.observe(this, {
            val tempShopList = ArrayList<ShopListItem>()
            it.forEach { item->
                val shopItem = ShopListItem(
                    item.id,
                    item.name,
                    "", false,0,
                    1
                )
                tempShopList.add(shopItem)
            }
            adapter?.submitList(tempShopList)
            binding.tvEmpty.visibility = if (it.isEmpty()) View.VISIBLE
            else View.GONE
        })
    }

    private fun initRcView() = with(binding) {
        adapter = ShopListItemAdapter(this@ShopListActivity)
        rcView.layoutManager = LinearLayoutManager(this@ShopListActivity)
        rcView.adapter = adapter
    }

    private fun expandActionView(): MenuItem.OnActionExpandListener{
        return object : MenuItem.OnActionExpandListener{

            override fun onMenuItemActionExpand(p0: MenuItem): Boolean {
                saveItem.isVisible = true
                edItem?.addTextChangedListener(textWatcher)
                libraryItemObserver()
                mainViewModel.getAllItemsFromList(shopListNameItem?.id!!).removeObservers(this@ShopListActivity)
                mainViewModel.getAllLibraryItems("%%")
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem): Boolean {
                saveItem.isVisible = false
                edItem?.removeTextChangedListener(textWatcher)
                invalidateOptionsMenu()
                mainViewModel.libraryItems.removeObservers(this@ShopListActivity)
                edItem?.setText("")
                listItemObserver()
                return true
            }
        }
    }

    private fun init() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            shopListNameItem =
                intent.getSerializableExtra(SHOP_LIST_NAME, ShopListNameItem::class.java)
        else
            shopListNameItem = intent.getSerializableExtra(SHOP_LIST_NAME) as ShopListNameItem
    }

    override fun onClickItem(shopListItem: ShopListItem, state: Int) {
        when (state) {
            ShopListItemAdapter.CHECK_BOX -> mainViewModel.updateListItem(shopListItem)
            ShopListItemAdapter.EDIT -> editListItem(shopListItem)
            ShopListItemAdapter.EDIT_LIBRARY_ITEM -> editLibraryItem(shopListItem)
            ShopListItemAdapter.ADD -> addNewShopItem(shopListItem.name)
            ShopListItemAdapter.DELETE_LIBRARY_ITEM -> {
                mainViewModel.deleteLibraryItem(shopListItem.id!!)
                mainViewModel.getAllLibraryItems("%${edItem?.text.toString()}%")
            }
        }

    }

    private fun editListItem(item: ShopListItem) {
        EditListItemDialog.showDialog(this, item, object : EditListItemDialog.Listener {
            override fun onClick(item: ShopListItem) {
                mainViewModel.updateListItem(item)
            }
        })
    }

    private fun editLibraryItem(item: ShopListItem) {
        EditListItemDialog.showDialog(this, item, object : EditListItemDialog.Listener {
            override fun onClick(item: ShopListItem) {
                mainViewModel.updateLibraryItem(LibraryItem(item.id, item.name))
                mainViewModel.getAllLibraryItems("%${edItem?.text.toString()}%")
            }
        })
    }

    private fun saveItemCount() {
        var checkedItemCounter = 0
        adapter?.currentList?.forEach {
            if (it.itemChecked) checkedItemCounter++
        }
        val tempShopListNameItem = shopListNameItem?.copy(
            allItemCounter = adapter?.itemCount!!,
            checkItemsCounter = checkedItemCounter
        )
        mainViewModel.updateListName(tempShopListNameItem!!)
    }

    private fun getSelectedTheme(): Int {
        return if (defPref.getString("theme_key", "blue") == "blue")
            R.style.Theme_ShoppingListBlue
        else R.style.Theme_ShoppingListGreen
    }

    override fun onDestroy() {
        saveItemCount()
        super.onDestroy()
    }

    override fun onPause() {
        saveItemCount()
        super.onPause()
    }


    companion object {
        const val SHOP_LIST_NAME = "shop_list_name"
    }
}