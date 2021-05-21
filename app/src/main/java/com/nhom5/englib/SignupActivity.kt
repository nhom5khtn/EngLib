package com.nhom5.englib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_welcome.*

class SignupActivity : AppCompatActivity() {

    //private lateinit var binding:ActivitySignupBinding

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserID:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()
        signup_btn.setOnClickListener {
            signupUser()
        }

        val signup_btn = findViewById<Button>(R.id.signup_btn)

        signup_btn.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signupUser() {
        var username:String=username_signup.text.toString()
        var email:String=email_signup.text.toString()
        var password:String=password_signup.text.toString()

        if(username == ""){
            Toast.makeText(this@SignupActivity,"Please write username", Toast.LENGTH_LONG).show()
        }
        else if(email == ""){
            Toast.makeText(this@SignupActivity,"Please write email", Toast.LENGTH_LONG).show()
        }
        else if(password == ""){
            Toast.makeText(this@SignupActivity,"Please write password", Toast.LENGTH_LONG).show()
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    task->
                if(task.isSuccessful){
                    firebaseUserID = mAuth.currentUser!!.uid
                    refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)

                    val userHashMap = HashMap<String, Any>()
                    userHashMap["uid"] = firebaseUserID
                    userHashMap["username"]=username

                    refUsers.updateChildren(userHashMap).addOnCompleteListener{
                            task->
                        if(task.isSuccessful){
                            val intent = Intent(this@SignupActivity, MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else{
                    Toast.makeText(this@SignupActivity,"Error Message: "+ task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                }
            }


        }


    }
}