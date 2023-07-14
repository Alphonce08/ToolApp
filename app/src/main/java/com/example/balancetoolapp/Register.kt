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
import java.util.regex.Pattern

class Register : AppCompatActivity() {
    lateinit var EditEmail:EditText
    lateinit var EditPassword:EditText
    lateinit var edtconfirm:EditText
    lateinit var BtRegister:Button
    lateinit var progress:ProgressDialog
    lateinit var mAuth:FirebaseAuth


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)
            EditEmail = findViewById(R.id.mEdtEmail)
            EditPassword = findViewById(R.id.mEdtPassword)
            edtconfirm = findViewById(R.id.edtConfirmPass)
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
                var password = EditPassword.text.toString().trim()
                //check if the user is submitting empty fields
                if (email.isEmpty()) {
                    EditEmail.setError("Please fill this input")
                    EditEmail.requestFocus()
                } else if (password.isEmpty()) {
                    EditPassword.setError("Please fill this input")
                    EditPassword.requestFocus()
                } else if (password.length < 6) {
                    EditPassword.setError("Password is too short")
                    EditPassword.requestFocus()
                } else {
                    //Validate email
                   // Pattern pattern = Patterns.EMAIL_ADDRESS;
                    //if(!patten.matcher(email).matches()){
                    EditEmail.setError("Please enter a valid email address")
                    EditEmail.requestFocus()
                        
                    }
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



