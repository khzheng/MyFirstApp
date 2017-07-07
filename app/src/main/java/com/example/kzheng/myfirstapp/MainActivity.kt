package com.example.kzheng.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kenButton = findViewById(R.id.kenButton)
        kenButton.setOnClickListener { kenButtonClicked(it) }

        val garthButton = findViewById(R.id.garthButton)
        garthButton.setOnClickListener { garthButtonClicked(it) }

        val benButton = findViewById(R.id.benButton)
        benButton.setOnClickListener { benButtonClicked(it) }
    }

    fun kenButtonClicked(view: View) {
        val intent = Intent(this, Landing1Activity::class.java)
        startActivity(intent)
    }

    fun garthButtonClicked(view: View) {
        // TODO: start your intent here
//        val intent = Intent(this, LoginActivityBen::class.java)
//        startActivity(intent)
    }

    fun benButtonClicked(view: View) {
        // TODO: start your intent here
//        val intent = Intent(this, LoginActivityBen::class.java)
//        startActivity(intent)
    }
}
