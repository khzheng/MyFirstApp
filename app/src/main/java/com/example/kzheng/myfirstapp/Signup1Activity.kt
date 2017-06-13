package com.example.kzheng.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Signup1Activity : AppCompatActivity() {
    lateinit var api: API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup1)

        api = API(this)

        val signupButton = findViewById(R.id.signupButton)
        signupButton.setOnClickListener { signup(it) }
    }

    fun signup(view: View) {
        val accountEditText: EditText? = findViewById(R.id.accountEditText) as? EditText
        val passwordEditText: EditText? = findViewById(R.id.passwordEditText) as? EditText
        val passwordConfirmEditText: EditText? = findViewById(R.id.passwordConfirmEditText) as? EditText

        val account = accountEditText?.text.toString()
        val password = passwordEditText?.text.toString()
        val passwordConfirm = passwordConfirmEditText?.text.toString()

        if (account.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty() && password.compareTo(passwordConfirm) == 0) {
            val doesAccountExist = api.doesAccountExist(account)
            if (doesAccountExist) {
                val toast = Toast.makeText(this, "Account already exists", Toast.LENGTH_LONG)
                toast.show()
            } else {
                val signupSuccess = api.signup(account, password)

                if (signupSuccess) {
                    val toast = Toast.makeText(this, "Signup success!", Toast.LENGTH_SHORT)
                    toast.show()

                    val intent = Intent(this, Login1Activity::class.java)
                    startActivity(intent)
                } else {
                    val toast = Toast.makeText(this, "Signup failed!", Toast.LENGTH_LONG)
                    toast.show()
                }
            }
        } else if (account.isEmpty()) {
            val toast = Toast.makeText(this, "Missing account name", Toast.LENGTH_LONG)
            toast.show()
        } else if (password.isEmpty()) {
            val toast = Toast.makeText(this, "Missing password", Toast.LENGTH_LONG)
            toast.show()
        } else if (passwordConfirm.isEmpty()) {
            val toast = Toast.makeText(this, "Confirm password", Toast.LENGTH_LONG)
            toast.show()
        } else if (password.compareTo(passwordConfirm) != 0) {
            val toast = Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG)
            toast.show()
        } else {
            val toast = Toast.makeText(this, "Signup failed!", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}
