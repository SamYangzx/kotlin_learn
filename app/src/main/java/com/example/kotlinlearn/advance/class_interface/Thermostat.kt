package com.example.kotlinlearn.advance.class_interface

import kotlin.properties.Delegates.observable

class Thermostat {
    var temperature: Double by observable(20.0) { _, old, new ->
        if (new > 25) {
            println("Warning: Temperature is too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }
    }
}

fun main() {
    val thermostat = Thermostat()
    thermostat.temperature = 22.5
    // 输出结果为: Temperature updated: 20.0°C -> 22.5°C

    thermostat.temperature = 27.0
    // 输出结果为: Warning: Temperature is too high! (22.5°C -> 27.0°C)
    thermostat.temperature = 24.0
}
