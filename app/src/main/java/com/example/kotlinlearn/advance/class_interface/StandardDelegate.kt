package com.example.kotlinlearn.advance.class_interface

/**
 * Kotlin 标准库提供了一些有用的委托, 让你不必总是从头创建.
 * 如果你使用这些委托, 你不需要定义 getValue() 和 setValue() 函数, 因为标准库会自动提供.
 */
class StandardDelegate {
    fun connect() {
        println("Connecting to the database...")
    }

    fun query(sql: String): List<String> {
        return listOf("Data1", "Data2", "Data3")
    }

}

/**
 * 线程安全
 */
val databaseConnection: StandardDelegate by lazy {
    val db = StandardDelegate()
    db.connect()
    db  //返回值
}

fun fetchData() {
    val data = databaseConnection.query("SELECT * FROM data")
    println("Data: $data")
}

fun main() {
    // 第 1 次访问 databaseConnection
    fetchData()
    // 输出结果为: Connecting to the database...
    // 输出结果为: Data: [Data1, Data2, Data3]

    println("second fetch.....")
    // 后续访问, 会使用已有的连接
    fetchData()
    // 输出结果为: Data: [Data1, Data2, Data3]
}