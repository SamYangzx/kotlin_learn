package com.example.kotlinlearn.basetype

class Contact(val id:Int, var email:String = "example@gmail.com") {
    var category:String = "work"

    override fun toString(): String {
//        return super.toString()
        return "[id=$id, email=$email]"
    }
}

fun main() {
    val contact = Contact(1001, "sam@lanmeng.com")
//    contact.id= 1002
    contact.email="jack@lanmeng.com"
    println(contact)
}