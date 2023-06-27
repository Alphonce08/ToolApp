package com.example.balancetoolapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var EditEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtRegister:Button
    lateinit var progress:ProgressDialog
    lateinit var mAuth:FirebaseAuth


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)
            EditEmail = findViewById(R.id.mEdtEmail)
            EdtPassword = findViewById(R.id.mEdtPassword)
            BtRegister = findViewById(R.id.BtnRegister)
            BtRegister.setOnClickListener {
                startActivity(Intent(applicationContext, MainActivity::class.java))

            }
            mAuth = FirebaseAuth.getInstance()
            progress = ProgressDialog(this)
            progress.setTitle("Loading")
            progress.setMessage("Please wait...")
            BtRegister.setOnClickListener {
                //start by receiving data from the user
                var email = EditEmail.text.toString().trim()
                var password = EdtPassword.text.toString().toString()
                //check if the user is submitting empty fields
                if (email.isEmpty()) {
                    EditEmail.setError("Please fill this input")
                    EditEmail.requestFocus()
                } else if (password.isEmpty()) {
                    EdtPassword.setError("Please fill this input")
                    EdtPassword.requestFocus()
                } else if (password.length < 6) {
                    EdtPassword.setError("Password is too short")
                    EdtPassword.requestFocus()
                } else {
                    //Proceed to register the user
                    progress.show()
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        progress.dismiss()
                        if (it.isComplete) {
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT)
                                .show()
                            mAuth.signOut()

                            finish()


                        }
                    }
                }
            }
        }
}



