package com.example.siimut

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.siimut.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityRegisterBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    //progress dialog
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        //init progress dialog, Register user
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait!")
        progressDialog.setCanceledOnTouchOutside(false)

        //handle back button click
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        //handle click
        binding.registerBtn.setOnClickListener {
            validateData()
        }

    }

    private var name = ""
    private var email = ""
    private var password = ""

    private fun validateData() {

        //input
        name = binding.nameEt.text.toString().trim()
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()
        val cPassword = binding.cPasswordEt.text.toString().trim()

        //validate
        if (name.isEmpty()){
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email
            Toast.makeText(this, "Invalid Email..." , Toast.LENGTH_SHORT).show()
        }
        else if (password.isEmpty()){
            //empty passwd
            Toast.makeText(this, "Enter Email..." , Toast.LENGTH_SHORT).show()
        }
        else if (cPassword.isEmpty()){
            //empty passwd
            Toast.makeText(this, "Confirm Email..." , Toast.LENGTH_SHORT).show()
        }
        else if (password != cPassword){
            Toast.makeText(this, "Password doesn't match..." , Toast.LENGTH_SHORT).show()
        }
        else{
            createUserAccount()
        }
        }

    private fun createUserAccount() {
        //create Account
        progressDialog.setMessage("Creating Account")
        progressDialog.show()

        //Create Account Firebase Aunt
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                updateUserInfo()

            }
            .addOnSuccessListener { e->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed creating account" , Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUserInfo() {
        progressDialog.setMessage("saving Account Info")

        //timestamp
        val timestamp = System.currentTimeMillis()

        //get uid
        val uid = firebaseAuth.uid

        //setupdata to add in db
        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"] = email
        hashMap["name"] = name
        hashMap["profileImage"] = ""
        hashMap["userType"] = "user"
        hashMap["timestamp"] = timestamp

        //set data to db
        val ref = FirebaseDatabase.getInstance().getReference("user")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {

            }
            .addOnFailureListener{

            }


    }
}