package com.example.hackaton

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    private val apiService = RetrofitClient.apiService
    private lateinit var buttonRegister: Button
    private lateinit var CreateEmailAddress: EditText
    private lateinit var CreateUserName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonRegister = findViewById(R.id.buttonRegister)
        CreateEmailAddress = findViewById(R.id.CreateEmailAddress)
        CreateUserName = findViewById(R.id.CreateUserName)

        buttonRegister.setOnClickListener {
            val email = CreateEmailAddress.text.toString().trim()
            val name = CreateUserName.text.toString().trim()

            if (email.isNotEmpty() && name.isNotEmpty()) {
                createUser(email, name)
            } else {
                Toast.makeText(this@Register, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createUser(email: String, name: String) {
        apiService.createUser(email, name).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@Register, "Registration successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@Register, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("Registration Error", "Failed: ${t.message}", t)
                Toast.makeText(this@Register, "Registration failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
