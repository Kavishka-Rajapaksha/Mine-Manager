package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class OnboardActivity02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard02)

        // Skip button click listener
        val skipButton: Button = findViewById(R.id.button3)
        skipButton.setOnClickListener {
            navigateToLoginActivity()
        }

        // Next button click listener
        val nextButton: Button = findViewById(R.id.button4)
        nextButton.setOnClickListener {
            navigateToOnboardActivity03()
        }
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish this activity to prevent going back to it
    }

    private fun navigateToOnboardActivity03() {
        val intent = Intent(this, OnboardActivity03::class.java)
        startActivity(intent)
    }
}
