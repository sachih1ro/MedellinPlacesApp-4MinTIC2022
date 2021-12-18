package com.example.medellinplaces.ui.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.medellinplaces.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}