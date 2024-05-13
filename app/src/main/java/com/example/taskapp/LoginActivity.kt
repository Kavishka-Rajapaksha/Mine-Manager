package com.example.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberMeCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox)

        rememberMeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                // Clear saved username and password if checkbox is unchecked
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_USERNAME, "")
                PreferenceHelper.setStringPreference(this, PreferenceHelper.KEY_PASSWORD, "")
            }
        }

        val savedUsername = PreferenceHelper.getStringPreference(this, PreferenceHelper.KEY_USERNAME)
        val savedPassword = PreferenceHelper.getStringPreference(this, PreferenceHelper.KEY_PASSWORD)

        if (!savedUsername.isNullOrEmpty() && !savedPassword.isNullOrEmpty()) {
            usernameEditText.setText(savedUsername)
            passwordEditText.setText(savedPassword)
            rememberMeCheckBox.isChecked = true
        }

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidInput(username, password)) {
                val correctUsername = PreferenceHelper.getStringPreference(this, PreferenceHelper.KEY_USERNAME)
                val correctPassword = PreferenceHelper.getStringPreference(this, PreferenceHelper.KEY_PASSWORD)

                if (username == correctUsername && password == correctPassword) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                    // Navigate to HomeActivity after successful login
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finish current activity to prevent user from going back to login screen
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val signUpTextView: TextView = findViewById(R.id.textView7)
        signUpTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidInput(username: String, password: String): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
