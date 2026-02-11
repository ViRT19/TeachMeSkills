package ru.ksppoisk.shoppinglist.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.ksppoisk.shoppinglist.R

class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(p0: Bundle?, p1: String?) {
        setPreferencesFromResource(R.xml.settings_preference, p1)
    }
}