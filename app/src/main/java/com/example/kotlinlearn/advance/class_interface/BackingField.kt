package com.example.kotlinlearn.advance.class_interface

import kotlin.properties.Delegates
class BackingField(val id: Int, val email: String) {

    val category: String = ""
    var name: String = ""
        set(value) {
//            name = value.replaceFirstChar { firstChar -> firstChar.uppercase() }
            field = value.replaceFirstChar { firstChar -> firstChar.uppercase() }
        }

//    val displayName: String by BackingField
}

val BackingField.fullField: String
    get() = "$id: $email"

fun main() {

    val field = BackingField(1, "sam@lanmeng.com")
    field.name = "sam"
    println(field.name)
    println(field.fullField)
}