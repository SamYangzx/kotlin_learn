package com.example.kotlinlearn.advance.api

class OptinTest {

}

@OptIn(ExperimentalUnsignedTypes::class)
fun main() {
    // 创建一个无符号整数的数组
    val unsignedArray: UIntArray = uintArrayOf(1u, 2u, 3u, 4u, 5u)

    // 修改一个元素
    unsignedArray[2] = 42u
    println("Updated array: ${unsignedArray.joinToString()}")
    // 输出结果为: Updated array: 1, 2, 42, 4, 5
}