package com.example.siimut

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.siimut.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

//    //view binding
//    private lateinit var binding: ActivityRegisterBinding
//
//    //firebase auth
//    private lateinit var firebaseAuth: FirebaseAuth
//
//    //progress dialog
//    private lateinit var progressDialog: ProgressDialog
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //init firebase auth
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        //init progress dialog, Register user
//        progressDialog = ProgressDialog(this)
//        progressDialog.setTitle("Please wait!")
//        progressDialog.setCanceledOnTouchOutside(false)
//
//        //handle back button click
//        binding.backBtn.setOnClickListener {
//            onBackPressed()
//        }
//
//        //handle click
//        binding.registerBtn.setOnClickListener {
//
//            validateData()
//        }
//
//    }
//
//    private var name = ""
//    private var email = ""
//    private var password = ""
//
//    private fun validateData() {
//
//        //input
//        name = binding.nameEt.text.toString().trim()
//        email = binding.emailEt.text.toString().trim()
//        password = binding.passwordEt.text.toString().trim()
//        val cPassword = binding.cPasswordEt.text.toString().trim
//
//        //validate
//        if (name.isEmpty()){
//            Toast.makeText(this, "ENter your name", Toast.LENGTH_SHORT).show()
//        }
//        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            //invalid email
//            Toast.makeText(this, "Invalid Email..." Toast)
//        }
//    }
}