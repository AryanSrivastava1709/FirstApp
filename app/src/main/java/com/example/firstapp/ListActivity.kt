package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), MyItemClickListener {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


       /* val integers = (1 .. 25).toList()

        val myAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,integers)
        binding.myListView.adapter = myAdapter
        //Giving item click listener to the listview
        binding.myListView.setOnItemClickListener { parent, view, position, id ->
            Log.d("ClickListener","Element " + (position+1)+ " was clicked")*/


        val  users = listOf(
            User("Aryan","Srivastava",20, "9999"),
            User("Sayiam","Arora",20, "8888"),
            User("Priyanshu","Pandey",20, "7777"),
            User("Anuj","Kushwaha",20, "6666"),
            User("Anchal","Srivastava",17, "5555"),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
        )

        //Layout Manager for the RV
        binding.recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)


        //Setting an adapter
        binding.recyclerView.adapter = MyAdapter(users,this)
    }

    data class User(
        val firstName : String = "ABC",
        val secondName: String = "XYZ",
        val age : Int = 20,
        val contactNumber : String = "0000"
    )

    override fun onItemClicked(user: User) {
        Log.d("ItemClicked",user.toString())

    }

    override fun onProfileClicked(user: User) {
        Log.d("ProfileClicked","${user.contactNumber}")
    }
}