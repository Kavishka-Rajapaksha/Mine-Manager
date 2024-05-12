package com.example.taskapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class OnboardActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard01)

        // Skip button click listener
        val skipButton: Button = findViewById(R.id.button)
        skipButton.setOnClickListener {
            navigateToLoginActivity()
        }

        // Next button click listener
        val nextButton: Button = findViewById(R.id.button2)
        nextButton.setOnClickListener {
            navigateToOnboardActivity02()
        }
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish this activity to prevent going back to it
    }

    private fun navigateToOnboardActivity02() {
        val intent = Intent(this, OnboardActivity02::class.java)
       startActivity(intent)
    }
}
