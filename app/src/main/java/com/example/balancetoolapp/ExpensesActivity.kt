package com.example.balancetoolapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.util.Date

class ExpensesActivity : AppCompatActivity() {

    //lateinit var ItemList:TextView
    lateinit var ExpnSum:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)
        //ItemList = findViewById(R.id.mListExpenses)
        ExpnSum = findViewById(R.id.BtnTotalExpenses)
    }
}