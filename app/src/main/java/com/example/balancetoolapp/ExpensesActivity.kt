package com.example.balancetoolapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.firebase.database.FirebaseDatabase
import java.util.Date
class ExpensesActivity : AppCompatActivity() {
    lateinit var datePicker: DatePicker
    lateinit var edtamount: EditText
    lateinit var edtdescription: EditText
    lateinit var btnbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        datePicker = findViewById<DatePicker>(R.id.datePickerid)

        edtamount = findViewById(R.id.edtAmount)
        edtdescription = findViewById(R.id.editDescription)
        btnbutton = findViewById(R.id.BtnSaved)

        var db = FirebaseDatabase.getInstance()




        btnbutton.setOnClickListener {


            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth)

            { _, year, month, dayOfMonth ->

                val selectedDate = "$year/${month + 1}/$dayOfMonth"

            }


            var amount = edtamount.text.toString().trim()
            var description = edtdescription.text.toString().trim()
            //to make unique id in our table
            var id = System.currentTimeMillis().toString()

            var ref = db.getReference("expense/" + id)

            //validate user input
            if (datePicker.isEmpty() || amount.isEmpty() || description.isEmpty()) {

                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            } else {

                var expenses = Expenses(datePicker.toString(), amount, description, id)

                ref.setValue(expenses).addOnCompleteListener {
                    if (it.isSuccessful) {

                        Toast.makeText(
                            this,
                            "Expenses Data Uploaded Successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {

                        Toast.makeText(this, "Failed to Upload Expenses Data", Toast.LENGTH_SHORT)
                            .show()


                    }

                }


            }}}}


