package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        //fetch the textview from the xml file

        val tvWelcome=findViewById<TextView>(R.id.tvWelcome)
        val username = intent.getStringExtra("USERNAME")
        tvWelcome.text="Welcome $username"
    }
}