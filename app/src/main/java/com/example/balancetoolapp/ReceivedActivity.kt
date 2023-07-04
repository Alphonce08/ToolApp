package com.example.balancetoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ReceivedActivity : AppCompatActivity() {
    lateinit var Tdate:TextView
    lateinit var edAmount:EditText
    lateinit var edDescription:EditText
    lateinit var BtButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_received)
        Tdate = findViewById(R.id.edtDate)
        edAmount = findViewById(R.id.editAmountRec)
        edDescription = findViewById(R.id.edtdescrp)
        BtButton = findViewById(R.id.mBtnSaved)
        BtButton.setOnClickListener {

        }
    }
}