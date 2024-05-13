package com.example.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (isValidInput(username, password, confirmPassword)) {
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_USERNAME, username)
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_PASSWORD, password)

                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()

                // Navigate to login activity after successful registration
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Finish current activity to prevent user from going back to register screen
            }
        }

        val signInTextView: TextView = findViewById(R.id.textView2)
        signInTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidInput(username: String, password: String, confirmPassword: String): Boolean {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }
        // Add more validation criteria as needed (e.g., password strength)
        return true
    }
}

