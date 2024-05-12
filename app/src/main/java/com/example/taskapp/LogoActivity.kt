package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent

class LogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handler to delay navigation
        Handler().postDelayed({
            // Intent to navigate to OnboardActivity01
  //          val intent = Intent(this, OnboardActivity01::class.java)
            startActivity(intent)
            // Finish current activity if you don't want to go back to it
            finish()
        }, 3000) // 3000 milliseconds = 3 seconds
    }
}
