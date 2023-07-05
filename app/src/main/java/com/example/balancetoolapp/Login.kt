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




class Login : AppCompatActivity() {
    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtLogin:Button
    lateinit var TxtSignup:TextView
    lateinit var progress:ProgressDialog
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        EdtEmail = findViewById(R.id.mEdtEmailLogin)
        EdtPassword = findViewById(R.id.medtPass)
        BtLogin = findViewById(R.id.BtnLogin)
        TxtSignup = findViewById(R.id.SignupTxt)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        BtLogin.setOnClickListener {
            //start by receiving data from the user
            var email = EdtEmail.text.toString().trim()
            var password = EdtEmail.text.toString().trim()
            //check if the user is submitting empty fields
            if (email.isEmpty()) {
                EdtEmail.setError("Please fill this input")
                EdtEmail.requestFocus()
            } else if (password.isEmpty()) {
                EdtPassword.setError("Please fill this input")
                EdtPassword.requestFocus()
            } else if (password.length < 6) {
                EdtPassword.setError("Password is too short")
                EdtPassword.requestFocus()
            } else {
                //Proceed to register the user
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isComplete) {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()


                    }
                }
            }
        }


        TxtSignup.setOnClickListener {
            startActivity(Intent(applicationContext, Register::class.java))
        }
    }

}



