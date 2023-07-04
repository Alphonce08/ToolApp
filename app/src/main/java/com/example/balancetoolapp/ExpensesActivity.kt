package com.example.balancetoolapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import java.util.Date
class ExpensesActivity : AppCompatActivity() {
    lateinit var Txtdate:TextView
    lateinit var edtamount:EditText
    lateinit var edtdescription:EditText
    lateinit var btnbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)
        Txtdate = findViewById(R.id.mBeditDate)
        edtamount = findViewById(R.id.edtAmount)
        edtdescription = findViewById(R.id.editDescription)
        btnbutton = findViewById(R.id.BtnSaved)
        btnbutton.setOnClickListener {

        }

    }
}



