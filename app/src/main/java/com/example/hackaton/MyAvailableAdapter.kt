
package com.example.hackaton

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAvailableAdapter(private val dataList: List<MyModel>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutResId = when (viewType) {
            MyModel.SELECTED_ITEM -> R.layout.selected_item
            MyModel.AVAILABLE_ITEM -> R.layout.available_item
            MyModel.NOT_AVAILABLE_ITEM -> R.layout.notavailable_item
            else -> throw IllegalArgumentException("Invalid view type")
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        when (item.itemType) {
            MyModel.SELECTED_ITEM -> {
                holder.buttonSelected.setBackgroundResource(item.backgroundResId)
                holder.buttonSelected.text = item.value
            }
            MyModel.AVAILABLE_ITEM -> {
                holder.buttonAvailable.setBackgroundResource(item.backgroundResId)
                holder.buttonAvailable.text = item.value
            }
            MyModel.NOT_AVAILABLE_ITEM -> {
                holder.buttonNotAvailable.setBackgroundResource(item.backgroundResId)
                holder.buttonNotAvailable.text = item.value
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].itemType as Int
    }
}
