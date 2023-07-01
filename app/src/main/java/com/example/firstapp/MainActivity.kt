package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnLogin)
        val etUsername = findViewById<TextInputEditText>(R.id.TIETUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.TIETPassword)

        val usernameLayout = findViewById<TextInputLayout>(R.id.username)
        val passwordLayout = findViewById<TextInputLayout>(R.id.password)

        val GoToFAQ: TextView= findViewById(R.id.tvFaq)

        btn.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val bundle = Bundle()
            bundle.putString("USER_KEY",username)
            bundle.putString("PASS_KEY",password)

            if (username.isBlank() || username.isEmpty()) {
                usernameLayout.error = "Please enter a valid username"
            }
            if (password.isEmpty()) {
                passwordLayout.error = "Please enter a valid password"
            }
            if(password=="000"){
                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                //intent.putExtra(Key,Value)
                //intent.putExtra("USERNAME",username)
                val intent=Intent(this@MainActivity,WelcomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@MainActivity,"Incorrect Password",Toast.LENGTH_SHORT).show()
            }
        }
        GoToFAQ.setOnClickListener{
            var url= "https://www.geeksforgeeks.org"
            var uri=Uri.parse(url)
            val implicitIntent=Intent(Intent.ACTION_VIEW,uri)
            startActivity(implicitIntent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        //Display a toast that user has exit the activity.  
        super.onDestroy()
    }
}

//Lifecycle of an activity

/*
* Created
* Started
* Resumed
*
* ------------------
*
* Paused
* Stopped
* Destroyed
* */


