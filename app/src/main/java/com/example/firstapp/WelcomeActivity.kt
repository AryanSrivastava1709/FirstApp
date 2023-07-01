package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        //fetch the textview from the xml file

        val tvWelcome=findViewById<TextView>(R.id.tvWelcome)
        val username = intent.extras?.getString("USER_KEY")
        val password = intent.extras?.getString("PASS_KEY")
        tvWelcome.text="Welcome $username"
    }
}