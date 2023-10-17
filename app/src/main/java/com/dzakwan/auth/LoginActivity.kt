package com.dzakwan.auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    val etUsername = findViewById<EditText>(R.id.etUsername)
    val etPassword = findViewById<EditText>(R.id.etPassword)
    val btnLogin = findViewById<Button>(R.id.btnLogin)

    btnLogin.setOnClickListener {
      val username = etUsername.text.toString()
      val password = etPassword.text.toString()

      // Retrieve username and password (for demonstration, use SharedPreferences)
      val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
      val savedUsername = sharedPreferences.getString("username", "")
      val savedPassword = sharedPreferences.getString("password", "")

      if (username == savedUsername && password == savedPassword) {
        // Login successful, redirect to the home screen
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
      } else {
        // Login failed, show an error message
        Toast.makeText(this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
      }
    }
  }
}
