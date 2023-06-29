package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        btn.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isBlank() || username.isEmpty()) {
                usernameLayout.error = "Please enter a valid username"
            }
            if (password.isEmpty()) {
                passwordLayout.error = "Please enter a valid password"
            }

            if (!(username.isEmpty() || username.isBlank() || password.isEmpty())) {
                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}