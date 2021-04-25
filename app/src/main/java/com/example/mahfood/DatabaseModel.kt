package com.example.mahfood

class DatabaseModel() {
    lateinit var name: String
    var price: Int = 0
    var count: Int = 0
    var total: Int = 0

    constructor(name: String, price: Int, count: Int) : this() {
        this.name = name
        this.price = price
        this.count = count
        this.total= this.price * this.count
    }
}