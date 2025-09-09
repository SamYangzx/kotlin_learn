package com.example.kotlinlearn.advance.class_interface

abstract class Animal {
    abstract val sound: String
    abstract fun makeSound()
}

class Dog: Animal() {

    override val sound: String
        get() = "wangwang"

    override fun makeSound() {
        println("sound: $sound")
    }
}

fun main() {
    val dog = Dog()
    dog.makeSound()
}