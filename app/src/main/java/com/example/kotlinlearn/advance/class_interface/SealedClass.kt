package com.example.kotlinlearn.advance.class_interface

/**
 * 1. 封闭类是一个特殊类型的 抽象类. 一旦将一个类声明为封闭, 就只能在同一个包之内创建它的子类.
 * 2. 封闭类在与 when 表达式一起使用时特别有用. 使用 when 表达式, 你可以对所有可能的子类定义行为.
 */
sealed class SealedClass {
    data class Const(val number: Double) : SealedClass()
    data class Sum(val e1: SealedClass, val e2: SealedClass) : SealedClass()
    object NotANumber : SealedClass()

    /**
     * 可根据传入的不同子类，做不同的动作
     */
    fun eval(expr: SealedClass): Double = when (expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotANumber -> Double.NaN
    }
}