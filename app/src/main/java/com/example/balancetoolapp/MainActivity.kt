package com.example.balancetoolapp



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {
    lateinit var BtnExpenses: Button
    lateinit var BtnReceived: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnExpenses = findViewById(R.id.mBExpenses)
        BtnReceived = findViewById(R.id.mBReceived)
        BtnExpenses.setOnClickListener {
            startActivity(Intent(applicationContext, ExpensesActivity::class.java))
        }
        BtnReceived.setOnClickListener {
            startActivity(Intent(applicationContext, ReceivedActivity::class.java))
        }


    }
}