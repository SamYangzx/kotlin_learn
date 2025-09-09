package com.example.kotlinlearn.advance

/**
 * 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
 */
class ExtensionFunction(var name: String) {

    /**
     * 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
     */
    fun Print() {
        println("inner print: $name")
    }
}

fun ExtensionFunction.Print() {
    println("user $name")
}

fun Any?.toString(): String {
    if (this == null) return "null fuck"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

fun main() {
    println("Hello".bold())
    var user = ExtensionFunction("sam")
    user.Print()

    println("---extension null")
    var t = null
    println(t.toString())
}

fun String.bold(): String = "<b>$this</b>"