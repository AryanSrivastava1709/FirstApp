package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.firstapp.databinding.ActivityFirebaseTestBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.util.UUID

class FirebaseTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirebaseTestBinding
    private lateinit var fireBase: FirebaseDatabase
    private lateinit var firebaseStorage :FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


       /* fireBase = FirebaseDatabase.getInstance("https://fir-test1-83936-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val reference = fireBase.reference

        val userReference = reference.child("Users")
        val bookReference = reference.child("Books")
        bookReference.child(UUID.randomUUID().toString()).setValue("The Fault in our stars")*/

        /*binding.btnLogin.setOnClickListener{

            //Add data to the database
            val firstName = binding.etUsername.text.toString()
            val lastName = binding.etPassword.text.toString()

            userReference.child(UUID.randomUUID().toString()).setValue("$firstName $lastName")
            binding.etUsername.text?.clear()
            binding.etPassword.text?.clear()
        }*/
/*
        //Fetch data from the firebase
        userReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Fetch Data","DB Updated")
                var str = ""
                snapshot.children.forEach {User ->
                    str += "${User.key}| |${User.value}\n"
                }
                binding.tv1.text = str
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })*/

        //Add Firebase Storage
        firebaseStorage = FirebaseStorage.getInstance()


        //Select an Image
        binding.selectBtn.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_PICK
            startActivityForResult(
                Intent.createChooser(intent,"Select an Image"),
                123
            )
        }

        //Set this image to the imageview
        //Upload it on the firebase


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123 && resultCode == RESULT_OK){
            if(data != null && data.data != null){
                val filePath = data.data
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filePath)
                binding.ivSelectImage.setImageBitmap(bitmap)

                binding.btnLogin.setOnClickListener {
                    val reference = firebaseStorage.reference
                    val imageReference = reference.child("images")
                    imageReference.child(UUID.randomUUID().toString()).putFile(filePath!!).addOnSuccessListener {
                        Log.d("Image Upload","Successfully Uploaded")
                    }.addOnFailureListener{
                        Log.d("Image Upload","${it.message}")
                    }
                }
            }
        }
    }
}