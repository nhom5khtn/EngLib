package com.nhom5.englib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        login_btn.setOnClickListener {
            loginUser()
        }

        val login_btn = findViewById<Button>(R.id.login_btn)

        login_btn.setOnClickListener {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        var email:String=email_login.text.toString()
        var password:String=password_login.text.toString()


        if(email == ""){
            Toast.makeText(this@LoginActivity,"Please write email", Toast.LENGTH_LONG).show()
        }
        else if(password == ""){
            Toast.makeText(this@LoginActivity,"Please write password", Toast.LENGTH_LONG).show()
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    task->
                if(task.isSuccessful){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                }
                else{
                    Toast.makeText(this@LoginActivity,"Error Message: "+ task.exception!!.message.toString(), Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}