package com.example.kzheng.myfirstapp

import android.util.Log

/**
 * Created by kzheng on 6/13/17.
 */
class API {
    fun login(account: String, password: String): Boolean {
        Log.i("API", "logging in with account: $account password: $password")

        var loginSuccess = true

        // TODO: actually check login credentials

        if (loginSuccess)
            Log.i("API", "login success")
        else
            Log.i("API", "login failed")

        return loginSuccess
    }
}