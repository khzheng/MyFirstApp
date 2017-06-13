package com.example.kzheng.myfirstapp

import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log

/**
 * Created by kzheng on 6/13/17.
 */
class API(context: Context) {
    val sharedPrefs = context.getSharedPreferences("com.myfirstapp.accounts", Context.MODE_PRIVATE)

    fun login(account: String, password: String): Boolean {
        Log.i("API", "login account: $account password: $password")

        var loginSuccess = false

        // check login credentials
        if (sharedPrefs.contains(account)) {
            if (password.compareTo(sharedPrefs.getString(account, null)) == 0  ) {
                loginSuccess = true
            } else {

            }
        } else {

        }

        // log
        if (loginSuccess)
            Log.i("API", "login success")
        else
            Log.i("API", "login failed")

        return loginSuccess
    }

    fun signup(account: String, password: String): Boolean {
        Log.i("API", "signup account: $account password: $password")

        // TODO: sanity checks: account and password requirements, account already exists

        val sharedPrefsEditor = sharedPrefs.edit()
        sharedPrefsEditor.putString(account, password)
        sharedPrefsEditor.apply()

        Log.i("API", "signup success")

        return true
    }

    fun doesAccountExist(account: String): Boolean {
        return sharedPrefs.contains(account)
    }
}