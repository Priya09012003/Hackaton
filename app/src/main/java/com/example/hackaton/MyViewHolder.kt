package com.example.hackaton

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val buttonnot: AppCompatButton = itemView.findViewById(R.id.notavailablebtn)
    val buttonavailable: AppCompatButton = itemView.findViewById(R.id.availablebtnitem)
    val buttonSelected: AppCompatButton = itemView.findViewById(R.id.selectedbtnItem)
}

