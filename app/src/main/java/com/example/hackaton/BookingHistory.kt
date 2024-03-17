package com.example.hackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookingHistory : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_history)
        val data = listOf(
            MyData("Desk ID", "Name", "Booked on", "31 May 2022 at 02:00PM", "12345", "Supriya Thete"),
            MyData("Desk ID", "Name", "Booked on", "30 May 2022 at 01:00PM", "21564", "Ram Lokhande"),
            MyData("Desk ID", "Name", "Booked on", "29 May 2022 at 12:00PM", "89451", "Priyanshu Jain"),
            MyData("Desk ID", "Name", "Booked on", "26 May 2022 at 01:00PM", "37903", "Priyanka Mahajan"),

        )

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(data)
        recyclerView.adapter = adapter
    }
}