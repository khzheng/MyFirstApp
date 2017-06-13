package com.example.kzheng.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

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

        if (account.isNotEmpty() && password.isNotEmpty()) {
            Log.i("login", "logging in with account: $account password: $password")

            // TODO: check login credentials
        } else {
            Log.i("login", "invalid account and password")

            val toast = Toast.makeText(this, "Invalid account and password", 5)
            toast.show()
        }
    }
}
