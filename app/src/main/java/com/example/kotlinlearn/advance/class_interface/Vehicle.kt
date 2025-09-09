package com.example.kotlinlearn.advance.class_interface

/**
 * kotlin class 默认为final， 不可被继承。
 * 2.默认不能覆写父类的成员函数或属性.
 */
open class Vehicle(val make: String, val model: String) {
    /**
     * 默认不能覆写父类的成员函数或属性。需要加 open
     */
    open fun displayInfo() {
        println("parent: $make")

    }
}

class Car(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model) {
    override fun displayInfo() {
//        super.displayInfo()
        println("son: $make")
    }
}

fun main() {
    // 创建 Car 类的一个实例
    val car = Car("Toyota", "Corolla", 4)

    // 打印输出汽车的详细信息
    println("Car Info: Make - ${car.make}, Model - ${car.model}, Number of doors - ${car.numberOfDoors}")
    // 输出结果为: Car Info: Make - Toyota, Model - Corolla, Number of doors - 4
    car.displayInfo()
}