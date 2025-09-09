package com.example.kotlinlearn.basetype

/**
 * 专为数据建模设计
 *
 * toString() → 如 "Person(name=Alice, age=23)"
 * equals() / hashCode() → 比较 name 和 age 是否相同
 * copy() → 如 person.copy(age = 24)
 * 解构支持 → 如 val (n, a) = person
 */
data class DataModel(
    val name: String,
    val age: Int,
    val sex: Boolean
)


fun main() {
    val data = DataModel("sam", 10, true)
    val jack = data.copy(name = "jack")
    println(data)
    println(jack)
}