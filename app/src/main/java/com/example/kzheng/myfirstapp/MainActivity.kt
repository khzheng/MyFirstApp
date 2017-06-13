package com.example.kzheng.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener { login(it) }

        val signupButton = findViewById(R.id.signupButton)
        signupButton.setOnClickListener { signup(it) }
    }

    fun login(view: View) {
        // change intent to your class to switch activities
        val intent = Intent(this, Login1Activity::class.java)
        startActivity(intent)
    }

    fun signup(view: View) {
        val intent = Intent(this, Signup1Activity::class.java)
        startActivity(intent)
    }
}
