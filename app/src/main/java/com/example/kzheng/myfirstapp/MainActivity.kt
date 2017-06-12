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
    }

    public fun login(view: View) {
        // change intent to your class to switch activities
        val intent = Intent(this, Login1Activity::class.java)
        startActivity(intent)
    }
}
