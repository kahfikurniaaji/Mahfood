package com.example.mahfood

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MenuItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemName = itemView.findViewById(R.id.itemName) as TextView
    private val itemPrice = itemView.findViewById(R.id.itemPrice) as TextView
    private val itemCount = itemView.findViewById(R.id.itemCount) as TextView
    private val itemRemove = itemView.findViewById(R.id.itemRemove) as Button
    private val itemAdd = itemView.findViewById(R.id.itemAdd) as Button
    private val itemPreview = itemView.findViewById(R.id.itemPreview) as ImageView

    fun bindContent(menuItem: MenuItem) {
        itemCount.text = menuItem.count.toString()
        itemName.text = menuItem.name
        itemPrice.text = "Rp. ${menuItem.price}"
        itemPreview.setImageResource(R.drawable.ic_breakfast)

        itemRemove.setOnClickListener {
            if (menuItem.count > 0) {
                menuItem.count--
            }
            itemCount.text = menuItem.count.toString()

        }

        itemAdd.setOnClickListener {
            menuItem.count++
            itemCount.text = menuItem.count.toString()
        }
    }

}