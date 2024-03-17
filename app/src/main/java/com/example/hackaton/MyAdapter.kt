package com.example.hackaton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val dataSet: List<MyData>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deskId: TextView = view.findViewById(R.id.DeskId)
        val name: TextView = view.findViewById(R.id.name)
        val bookedOn: TextView = view.findViewById(R.id.bookedon)
        val bookedOnTv: TextView = view.findViewById(R.id.bookedontv)
        val deskIdN: TextView = view.findViewById(R.id.deskidn)
        val nameTv: TextView = view.findViewById(R.id.nametv)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.history_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.deskId.text = item.deskIdLabel
        viewHolder.name.text = item.nameLabel
        viewHolder.bookedOn.text = item.bookedOnLabel
        viewHolder.bookedOnTv.text = item.bookedOnValue
        viewHolder.deskIdN.text = item.deskIdValue
        viewHolder.nameTv.text = item.nameValue
    }

    override fun getItemCount() = dataSet.size
}
