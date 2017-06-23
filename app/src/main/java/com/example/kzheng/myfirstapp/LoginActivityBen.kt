package com.example.kzheng.myfirstapp


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.kzheng.myfirstapp.R.layout.activity_loginben

class LoginActivityBen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_loginben)

        val loginButton = findViewById(R.id.loginButton)
        val signInButton = findViewById(R.id.signUpButton)

        val sniper = findViewById(R.id.dotasniper)
    }

    fun login(view: View) {
        val loginEmail: EditText? = findViewById(R.id.loginEmail) as? EditText
        val loginPassword: EditText? = findViewById(R.id.loginPassword) as? EditText
        val sniper: ImageView? = findViewById(R.id.dotasniper) as? ImageView

        val email = loginEmail?.text.toString()
        val password = loginPassword?.text.toString()
    }

}
