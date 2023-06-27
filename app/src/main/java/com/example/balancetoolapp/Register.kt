package com.example.balancetoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Register : AppCompatActivity() {
    lateinit var EditEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        EditEmail = findViewById(R.id.mEdtEmail)
        EdtPassword = findViewById(R.id.mEdtPassword)
        BtRegister = findViewById(R.id.BtnRegister)
        BtRegister.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))

        }




    }
}