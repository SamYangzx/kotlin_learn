package com.example.kotlinlearn.advance.class_interface

interface IAnimal {
    abstract val sound: String
    abstract fun makeSound()
}

class DogByI: IAnimal {

    override val sound: String
        get() = "wangwang"

    override fun makeSound() {
        println("Interface sound: $sound")
    }
}

fun main() {
    val dog = DogByI()
    dog.makeSound()
}