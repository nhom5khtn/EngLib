package com.nhom5.englib

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    lateinit var handle: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)        // delay 3 seconds to open MainActivity
    }
}