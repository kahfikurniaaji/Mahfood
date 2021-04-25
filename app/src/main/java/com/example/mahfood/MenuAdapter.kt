package com.example.mahfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val data: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_HEADER = 0
        private const val ITEM_MENU = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is String -> ITEM_HEADER
            is MenuItem -> ITEM_MENU
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_HEADER -> MenuHeaderHolder(inflater.inflate(R.layout.item_header, parent, false))
            ITEM_MENU -> MenuItemHolder(inflater.inflate(R.layout.item_menu, parent, false))
            else -> throw throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_HEADER -> {
                val headerHolder = holder as MenuHeaderHolder
                headerHolder.bindContent(data[position] as String)
            }
            ITEM_MENU -> {
                val itemHolder = holder as MenuItemHolder
                itemHolder.bindContent(data[position] as MenuItem)
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount() = data.size

}