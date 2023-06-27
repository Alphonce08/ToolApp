package com.example.balancetoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {
    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var TxtRegister:TextView
    lateinit var BtLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        EdtEmail = findViewById(R.id.mEdtEmailLogin)
        EdtPassword = findViewById(R.id.medtPass)
        TxtRegister = findViewById(R.id.TextNoAccount)
        BtLogin = findViewById(R.id.BtnLogin)

        BtLogin.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        TxtRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
        }


    }

