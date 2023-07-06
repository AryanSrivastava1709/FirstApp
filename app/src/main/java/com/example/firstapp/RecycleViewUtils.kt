package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.firstapp.ListActivity.User


//Step 1: ViewHolder -- For holding the custom layout file for out list items
class MyViewHolder(itemView: View) : ViewHolder(itemView){

    private val ivProfilePic : ImageView = itemView.findViewById(R.id.ivUserPic)
    private val tvFirstName : TextView = itemView.findViewById(R.id.tvFirstName)
    private val tvLastName : TextView = itemView.findViewById(R.id.tvSecondName)
    private val tvAge : TextView = itemView.findViewById(R.id.tvAge)
    private val tvNumber : TextView = itemView.findViewById(R.id.tvContactNumber)

    fun bindData(user: User,listener: MyItemClickListener){
        //ivProfilePic.setImage("Some Image")
        tvFirstName.text=user.firstName
        tvLastName.text=user.secondName
        tvAge.text=(user.age).toString()
        tvNumber.text=user.contactNumber
        itemView.setOnClickListener{
            listener.onItemClicked(user)
        }
        ivProfilePic.setOnClickListener{
            listener.onProfileClicked(user)
        }
    }
}


//Step 2: Adapter -- Connecting everything together and then providing them to the RV
class MyAdapter(private val users: List<User>, private val listener: MyItemClickListener): Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //attach the view and then convert it to myView.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_list_item,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users[position]
        holder.bindData(user,listener)
    }

    override fun getItemCount(): Int {
        //return the size of the list that needs to be populated
        return users.size
    }
}


//Interface -- for defining the click events on the list items.

interface MyItemClickListener{
    fun onItemClicked(user: User)
    fun onProfileClicked(user: User)
}