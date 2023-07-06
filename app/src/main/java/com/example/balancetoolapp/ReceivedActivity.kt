package com.example.balancetoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.firebase.database.FirebaseDatabase

class ReceivedActivity : AppCompatActivity() {
    lateinit var datePicker: DatePicker
    lateinit var edAmount:EditText
    lateinit var edDescription:EditText
    lateinit var BtButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_received)
        datePicker = findViewById<DatePicker>(R.id.datePickerida)
        edAmount = findViewById(R.id.editAmountRec)
        edDescription = findViewById(R.id.edtdescrp)
        BtButton = findViewById(R.id.mBtnSaved)
        BtButton.setOnClickListener {
            var db = FirebaseDatabase.getInstance()




            BtButton.setOnClickListener {


                datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth)

                { _, year, month, dayOfMonth ->

                    val selectedDate = "$year/${month + 1}/$dayOfMonth"

                }


                var amount = edAmount.text.toString().trim()
                var description = edDescription.text.toString().trim()
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
                                "Received Data Uploaded Successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            Toast.makeText(this, "Failed to Upload Expenses Data", Toast.LENGTH_SHORT)
                                .show()


                        }

                    }


                }

        }
    }
}
}