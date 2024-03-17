package com.example.hackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.hackaton.R

class Confirmation : AppCompatActivity() {

    private lateinit var button : Button
    // create a alertdialog
    private lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // button = findViewById(R.id.buttone)
        // we have a simple button of id button
        // on button click we will open alert box

        builder = AlertDialog.Builder(this)

        button.setOnClickListener{
            builder.setTitle("Alert!")
                .setMessage("Do you want to exit ?")
                .setCancelable(true) // dialog box in cancellable
                // set positive button
                //take two parameters dialogInterface and an int
                .setPositiveButton("Yes"){dialogInterface,it ->
                    finish() // close the app when yes clicked
                }
                .setNegativeButton("No"){dialogInterface,it ->
                    // cancel the dialogbox
                    dialogInterface.cancel()
                }
                .setNeutralButton("Help"){dialogInterface,it ->
                    // just show a toast
                    Toast.makeText(this@Confirmation,"Help Clicked",Toast.LENGTH_SHORT).show()
                }
                // show the builder
                .show()
        }
    }
}