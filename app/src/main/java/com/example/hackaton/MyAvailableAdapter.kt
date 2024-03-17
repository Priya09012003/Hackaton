package com.example.hackaton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class MyAvailableAdapter(private val dataList: List<MyModel>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutResId = when (viewType) {
            MyModel.SELECTED_ITEM -> R.layout.selectedbtnItem
            MyModel.AVAILABLE_ITEM -> R.layout.availablebtnitem
            MyModel.NOT_AVAILABLE_ITEM -> R.layout.notavailablebtn
            else -> throw IllegalArgumentException("Invalid view type")
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        when (item.backgroundResId) {
            R.drawable.selectbtn -> {
                holder.buttonSelected.setBackgroundResource(item.backgroundResId)
                holder.buttonSelected.text = item.value
            }
            R.drawable.available -> {
                holder.buttonAvailable.setBackgroundResource(item.backgroundResId)
                holder.buttonAvailable.text = item.value
            }
            R.drawable.notbtn -> {
                holder.buttonNotAvailable.setBackgroundResource(item.backgroundResId)
                holder.buttonNotAvailable.text = item.value
            }
            else -> throw IllegalArgumentException("Invalid background resource ID")
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = dataList[position]
        return when (item.backgroundResId) {
            R.drawable.selectbtn -> MyModel.SELECTED_ITEM
            R.drawable.available -> MyModel.AVAILABLE_ITEM
            R.drawable.notbtn -> MyModel.NOT_AVAILABLE_ITEM
            else -> throw IllegalArgumentException("Invalid background resource ID")
        }
    }
}
