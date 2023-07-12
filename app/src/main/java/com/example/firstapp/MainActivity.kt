package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.firstapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        auth=FirebaseAuth.getInstance()

        bind.btnLogin.setOnClickListener {
            val username = bind.TIETUsername.text.toString()
            val password = bind.TIETPassword.text.toString()
            val bundle = Bundle()
            bundle.putString("USER_KEY",username)
            bundle.putString("PASS_KEY",password)

            if (username.isBlank()) {
                bind.username.error = "Please enter a valid username"
            }
            if (password.isEmpty()) {
                bind.password.error = "Please enter a valid password"
            }
            //check if user exists
            //if exists goto next screen
            //if not create a user with mail id and password


            if(checkFormDetails(username,password)){
                /*Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                //intent.putExtra(Key,Value)
                //intent.putExtra("USERNAME",username)
                val intent=Intent(this@MainActivity,WelcomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)*/

                auth.signInWithEmailAndPassword(username,password).addOnCompleteListener {signInTask ->
                    if (signInTask.isSuccessful){
                        Log.d("Login","Sign In Successfull")
                    }else{
                        Log.d("Login","${signInTask.exception}")
                        auth.createUserWithEmailAndPassword(username,password).addOnCompleteListener { signUpTask ->
                            if(signUpTask.isSuccessful){
                                Log.d("Login","Sign Up Succesfull")
                            }
                            else{
                                Log.d("Login","${signUpTask.exception}")
                            }
                        }
                    }
                }
            }
        }
        bind.tvFaq.setOnClickListener{
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
    private fun checkFormDetails(username:String,password:String):Boolean{
        return !(username.isBlank() || password.isEmpty())
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


