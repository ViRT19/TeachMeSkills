package ru.ksppoisk.shoppinglist.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.MenuItem
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.activities.MainActivity
import ru.ksppoisk.shoppinglist.activities.marginTop

class SettingsActivity : AppCompatActivity() {
    private lateinit var defPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        defPref = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(getSelectedTheme())
        setContentView(R.layout.activity_settings)
        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, SettingsFragment())
                .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        marginTop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun getSelectedTheme(): Int {
        return if (defPref.getString("theme_key", "blue") == "blue")
            R.style.Theme_ShoppingListBlue
        else R.style.Theme_ShoppingListGreen
    }

}
