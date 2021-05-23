package com.nhom5.englib

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.edit

class QuestionActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val btnSkip = findViewById<Button>(R.id.btnSkip)

        val saveConfig = getSharedPreferences("CONFIGURATION", Context.MODE_PRIVATE)

        saveConfig?.edit {
            putString("DEFAULT_WAIT_TIME","10.0F")
            putString("DEFAULT_NUM_QUEST","30.0F")
        }

        val savedWaitTime = saveConfig?.getString("WAIT_TIME","10.0F")
        val savedNumQuest = saveConfig?.getString("NUM_QUEST","30.0F")
        Log.e(">>>>> savedWaitTime","$savedWaitTime")
        Log.e(">>>>> savedtNumQuest","$savedNumQuest")
        if (savedWaitTime != null) {
            var WaitTime = saveConfig.getString("DEFAULT_WAIT_TIME","10.0F")
            Log.e(">>>>> savedWaitTime","$WaitTime")
        }
        if (savedNumQuest != null) {
            var NumQuest = saveConfig.getString("DEFAULT_NUM_QUEST","30.0F")
            Log.e(">>>>> savedtNumQuest","$NumQuest")
        }

        btnSkip.setOnClickListener {
            val intentHomeActivity = Intent(this,HomeActivity::class.java)
            startActivity(intentHomeActivity)
        }



    }
}