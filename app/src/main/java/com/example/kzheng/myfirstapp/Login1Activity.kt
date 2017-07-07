package com.example.kzheng.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class Login1Activity : AppCompatActivity() {
    lateinit var api: API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        api = API(this)

        val loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener { login(it) }
    }

    public fun login(view: View) {
        val accountEditText: EditText? = findViewById(R.id.accountEditText) as? EditText
        val passwordEditText: EditText? = findViewById(R.id.passwordEditText) as? EditText

        val account = accountEditText?.text.toString()
        val password = passwordEditText?.text.toString()

        if (account.isNotEmpty() && password.isNotEmpty()) {
            val loginSuccess = api.login(account, password)
            if (loginSuccess) {
                val toast = Toast.makeText(this, "Login success!", Toast.LENGTH_LONG)
                toast.show()

                val intent = Intent(this, List1Activity::class.java)
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG)
                toast.show()
            }
        } else {
            val toast = Toast.makeText(this, "Invalid account and password", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}
