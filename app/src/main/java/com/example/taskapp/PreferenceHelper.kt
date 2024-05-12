package com.example.taskapp

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val PREF_NAME = "MyManagerPrefs"
    const val KEY_USERNAME = "username"
    const val KEY_PASSWORD = "password"

    fun getStringPreference(context: Context, key: String): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }

    fun setStringPreference(context: Context, key: String, value: String) {
        val sharedPreferences: SharedPreferences.Editor =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        sharedPreferences.putString(key, value)
        sharedPreferences.apply()
    }
}
