package com.example.mahfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mahfood.Menu.Companion.menus
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_menu.*

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    private var menuData = listOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Pesanan")

        menuData = Menu.menus

        val menuAdapter = MenuAdapter(menuData)

        menuItem.hasFixedSize()
        menuItem.layoutManager = LinearLayoutManager(this)
        menuItem.adapter = menuAdapter

        tvLokasi.setOnClickListener {
            // Untuk Maps
            startActivity(Intent(applicationContext, MapsActivity::class.java))
        }

        btnOrder.setOnClickListener {
            // Untuk Firebase
            // sendNotification()
            sendData()
        }
    }

    private fun sendData() {

        for (item in menuData) {
            when (item) {
                is MenuItem -> {
                    if (item.count != 0) {
                        val model = DatabaseModel(item.name, item.price, item.count)
                        val id = reference.push().key

                        reference.child(id!!).setValue(model)
                    }
                }
            }
        }
    }

    // Function error
    private fun sendNotification() {
        var builder = NotificationCompat.Builder(this@MainActivity, BaseNotification.CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_android)
            .setContentTitle("Mahfood")
            .setContentText("Order Success")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        var notification = builder.build()
        notificationManager.notify(1, notification)
    }

}