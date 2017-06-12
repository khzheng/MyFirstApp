package com.example.kzheng.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class Login1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        val loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener { login(it) }
    }

    public fun login(view: View) {
        val accountEditText: EditText? = findViewById(R.id.accountEditText) as? EditText
        val passwordEditText: EditText? = findViewById(R.id.passwordEditText) as? EditText

        val account = accountEditText?.text.toString()
        val password = passwordEditText?.text.toString()

        if (account.length > 0 && password.length > 0) {
            Log.i("login", "logging in with account: $account password: $password")
        } else {
            Log.i("login", "invalid account and password")
        }
    }
}
