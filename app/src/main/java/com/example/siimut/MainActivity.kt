package com.example.siimut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.siimut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //Button Login
        binding.LoginBtn.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))

        }

        //Button SignIn
        binding.LogBtn.setOnClickListener {

        }
    }
}