package com.example.mahfood

data class MenuItem(
    val name: String,
    val price: Int,
    var count: Int,
    val itemPreview: Int
)