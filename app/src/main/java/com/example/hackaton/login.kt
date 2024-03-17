package com.example.hackaton

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {

    private val apiService = RetrofitClient.apiService
    private lateinit var buttonLogin: AppCompatButton
    private lateinit var CreateUserNamelogin: EditText
    private lateinit var CreatePasswordlogin: EditText
    private lateinit var createNewUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.nextbtnBook)
        CreateUserNamelogin = findViewById(R.id.CreateUserNamelogin)
        CreatePasswordlogin = findViewById(R.id.createpass)
        createNewUser = findViewById(R.id.createacc)

        createNewUser.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val email = CreateUserNamelogin.text.toString().trim()
            val password = CreatePasswordlogin.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this@login, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        apiService.loginUser(email, password).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@login, "Login successful", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@login, MainActivity::class.java)
                    startActivity(intent)

                    finish()
                } else {
                    Toast.makeText(this@login, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@login, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
