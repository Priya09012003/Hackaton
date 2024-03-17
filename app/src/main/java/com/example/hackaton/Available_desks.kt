package com.example.hackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hackaton.RetrofitClient.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Available_desks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_desks)


        val apiService=RetrofitClient.apiService


         fun getAvailablity() {
            apiService.getAvailablity().enqueue(object : Callback<List<Model>> {
                override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                    if (response.isSuccessful) {
                        val models = response.body()
                        val modelsString = models?.joinToString("\n") { model ->
                            "Workspace Name: ${model.workspace_name}, Workspace ID: ${model.workspace_id}, Workspace Active: ${model.workspace_active}"
                        }

                        // Log the string representation of the models
                        Log.d("data", modelsString ?: "Empty response")
                        // Handle the list of models here
                    } else {
                        // Handle API error
                    }
                }

                override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                    // Handle network failure
                }
            })
        }

        getAvailablity()
    }
}