package com.example.balancetoolapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.NonCancellable.message

class Login : AppCompatActivity() {
    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var TxtRegister:TextView
    lateinit var BtLogin:Button
    lateinit var progress:ProgressDialog
    lateinit var mAuth:FirebaseAuth
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
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        BtLogin.setOnClickListener {

            //start by receiving data from the user
            var email = EdtEmail.text.toString().trim()
            var password = EdtPassword.text.toString().toString()
            //check if the user is submitting empty fields
            if (email.isEmpty()){
                EdtEmail.setError("Please fill this input")
                EdtEmail.requestFocus()
            } else if (password.isEmpty()){
                EdtPassword.setError("Please fill this input")
                EdtPassword.requestFocus()
            } else {
                //Proceed to Login the user
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isComplete){
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                        finish()

                    } else {
                        displayMessage("ERROR", it.exception!!.message.toString())
                        var alertDialog = AlertDialog.Builder(this)
                        alertDialog.setTitle(title)
                        alertDialog.setMessage(message)
                        alertDialog.setPositiveButton("Ok", null)
                        alertDialog.create().show()
                    }
                }
            }
        }
        }


    }

