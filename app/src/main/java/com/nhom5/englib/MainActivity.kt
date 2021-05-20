package com.nhom5.englib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLaunch = findViewById<Button>(R.id.btnLaunch)

        btnLaunch.setOnClickListener {
            val intentHomeActivity = Intent(this,HomeActivity::class.java)
            startActivity(intentHomeActivity)
        }

    }
}