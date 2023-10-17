package com.dzakwan.auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)

    val etUsername = findViewById<EditText>(R.id.etUsername)
    val etPassword = findViewById<EditText>(R.id.etPassword)
    val btnRegister = findViewById<Button>(R.id.btnRegister)

    btnRegister.setOnClickListener {
      val username = etUsername.text.toString()
      val password = etPassword.text.toString()

      // Store username and password (for demonstration, use SharedPreferences)
      val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
      val editor = sharedPreferences.edit()
      editor.putString("username", username)
      editor.putString("password", password)
      editor.apply()

      // Redirect to the login screen
      val intent = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }
  }
}
