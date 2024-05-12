package com.example.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_USERNAME, username)
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_PASSWORD, password)

                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()

                // Navigate to login activity after successful registration
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Finish current activity to prevent user from going back to register screen
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
