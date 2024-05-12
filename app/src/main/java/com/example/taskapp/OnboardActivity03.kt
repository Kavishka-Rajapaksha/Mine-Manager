package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class OnboardActivity03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard03)

        // Get Started button click listener
        val getStartedButton: Button = findViewById(R.id.button5)
        getStartedButton.setOnClickListener {
            navigateToLoginActivity()
        }
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish() // Finish this activity to prevent going back to it
    }
}
