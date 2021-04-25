package com.example.mahfood

class Menu {
    companion object {
        val menus: MutableList<Any>
            get() = mutableListOf(
                "Nasi Goreng",
                MenuItem("Nasi Goreng Original", 15000, 0, R.drawable.ic_breakfast),
                MenuItem("Nasi Goreng Super Pedas", 17000, 0, R.drawable.ic_breakfast),
                MenuItem("Nasi Goreng Seafood", 20000, 0, R.drawable.ic_breakfast),
                MenuItem("Nasi Goreng Spesial", 30000, 0, R.drawable.ic_breakfast),
                MenuItem("Nasi Goreng Babat", 16000, 0, R.drawable.ic_breakfast),
                MenuItem("Nasi Goreng Merah", 18000, 0, R.drawable.ic_breakfast)
            )
    }
}