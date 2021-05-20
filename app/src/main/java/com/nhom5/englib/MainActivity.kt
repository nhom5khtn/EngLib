package com.nhom5.englib

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Wrong reply")
        builder.setMessage("Do you want to quit?")
        builder.setPositiveButton("Give Up!", { dialogInterface: DialogInterface, i: Int ->
            finish()
        })
        builder.setNegativeButton("Continue!", { dialogInterface: DialogInterface, i: Int ->
        })
        builder.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

    }
}