package com.example.firstapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.firstapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //fetch the textview from the xml file

       // val tvWelcome=findViewById<TextView>(R.id.tvWelcome)
        val username = intent.extras?.getString("USER_KEY")
        val password = intent.extras?.getString("PASS_KEY")
        // tvWelcome.text="Welcome $username"
        binding.tvWelcome.text = "Welcome $username"


        // SharedPrefs

        /*
        * Is basically  storing all your data in a file , that is only accessible to one app
        * Latest alternative  to sharePref is DataStore
        * */


        val contactNum = "7844868680"
        val isAdmin = true
        val ageOfUser = 20

        val sharedPrefs = getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(SP_CONTACT_NUMBER_KEY,contactNum)
        editor.putBoolean(SP_IS_ADMIN_KEY,isAdmin)
        editor.putInt(SP_AGE_KEY,ageOfUser)
        editor.apply() //pushes the data in async manner
//        editor.commit() It pushes the value asap( in a sync manner )


        // How to access the data from sharedPrefs

        val sharedPreferences = getSharedPreferences(SHARED_PREF_FILE_NAME,Context.MODE_PRIVATE)

        val cNum = sharedPreferences.getString(SP_CONTACT_NUMBER_KEY, "No Number Found")
        val isAdm = sharedPreferences.getBoolean(SP_IS_ADMIN_KEY, false)
        val age = sharedPreferences.getInt(SP_AGE_KEY, 0)
        val name = sharedPreferences.getString("nameKey", "No Name Found")

        Log.d("Shared Preferences:  ", "$cNum, $isAdm, $age, $name")
    }
}