package com.example.hackaton

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val buttonSelected: Button = itemView.findViewById(R.id.selectedbtnItem)
    val buttonAvailable: Button = itemView.findViewById(R.id.availablebtnitem)
    val buttonNotAvailable: Button = itemView.findViewById(R.id.notavailablebtn)
}
