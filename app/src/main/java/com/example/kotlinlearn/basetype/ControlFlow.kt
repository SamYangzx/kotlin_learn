package com.example.kotlinlearn.basetype


fun main() {
    val controlFlow = ControlFlow()
//    controlFlow.testBase()
//    controlFlow.testRange()
//    controlFlow.testWhen()
    controlFlow.testLoop()

}

class ControlFlow {

    fun testBase() {
        val a = 10
        val b = 9
        val max = if (a > b) {
            println("Choose a")
            a
        } else {
            println("Choose b")
            b
        }

    }

    fun testRange() {
        //区间
        val x = 5
        val y = 9
        if (x in 1..8) {
            println("x 在区间内")
        }
    }

    fun testWhen() {
        var x = 1
        when (x) {
            1 -> println("1")  //no need break
            2 -> println("2")
            else -> {
                println("not 1 or 2")
            }
        }

        var y = "1"
        when (y) {
            "0", "1" -> println("x == 0 or x == 1")
            else -> println("otherwise")
        }


        val items = setOf("apple", "banana", "kiwi")
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }


        val trafficLightState = "Red" // This can be "Green", "Yellow", or "Red"

        val trafficAction = when {
            trafficLightState == "Green" -> "Go"
            trafficLightState == "Yellow" -> "Slow down"
            trafficLightState == "Red" -> "Stop"
            else -> "Malfunction"
        }

        println(trafficAction)
    }


    fun testLoop() {
        for (number in 1..5 step 2) {
            println("number: $number")
        }

        val fruits = listOf("apple", "banana", "cherry")
        for (fruit in fruits) {
            println("fruit: $fruit")
        }

        println("test while ----")
        var index = 0
        while (index < 3) {
            index++
            println("eat $index cake ")
        }

        index = 0
        do {
            index++
            println("make $index cakes")
        } while (index < 3)
    }
}