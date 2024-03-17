package com.example.hackaton

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var btnHistory: AppCompatButton
    private lateinit var cardbookWorkStation: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHistory = findViewById<AppCompatButton>(R.id.btnHistory)
        cardbookWorkStation = findViewById(R.id.cardbookWorkStation)


        btnHistory.setOnClickListener{
            val intent = Intent(this, BookingHistory::class.java)
            startActivity(intent)
        }
        cardbookWorkStation.setOnClickListener {
            val intent = Intent(this, BookWorkStation::class.java)
            startActivity(intent)
        }
    }
}

