package com.example.kotlinlearn.advance

/**
 * 如同定义了一个模板
 */
class LambdaReceiver {
}

class CustomCanvas {
    fun drawCircle() = println("🟠 Drawing a circle")
    fun drawSquare() = println("🟥 Drawing a square")
}

// Lambda expression with receiver definition
fun render(block: CustomCanvas.() -> Unit): CustomCanvas {
    val canvas = CustomCanvas()
    // Use the lambda expression with receiver
    canvas.block()
    return canvas
}

fun main() {
    render {
        drawCircle()
        // 🟠 Drawing a circle
        drawSquare()
        // 🟥 Drawing a square
    }
}