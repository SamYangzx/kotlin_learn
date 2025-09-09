package com.example.kotlinlearn.advance

class ScopeFunction {
}

fun sendNotification(recipientAddress: String): String {
    println("Yo $recipientAddress!")
    return "Notification sent!"
}

fun getNextAddress(): String {
    return "sebastian@jetbrains.com"
}

fun main() {
//    testLet()
    testApply()
}

/**
函数	适用场景	this / it	返回值
​let​	对非空对象执行代码、变换返回值	it	Lambda ​最后一行​
​with​	对某个对象执行多个操作（非扩展函数）	this	Lambda ​最后一行​
​run​	类似 with，但是是扩展函数	this	Lambda ​最后一行​
​apply​	初始化或配置对象，修改其属性	this	​对象本身（this）​​
​also​	执行额外操作（如日志、检查），同时保留原对象	it	​对象本身（it）​
 */
fun testLet() {
    val address: String? = getNextAddress()
    //防空处理；类型转换等
    val confirm = address?.let {
        sendNotification(it)
    }
}

class Client() {
    var token: String? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData(): String = "Mock data"
}

/**
 * 创建时初始化，更加易读和管理。
 */
fun testApply() {
    val client = Client().apply {
        token = "token"
        connect()
        authenticate()
    }
    client.getData()
}

/**
 *  绑定多个操作
 */
fun testRun() {
    val client = Client().apply {
        token = "token"
    }

    client.run {
        connect()
        authenticate()
        getData()
    }
}

/**
 * 执行额外的操作
 * 1.还是原来的对象；
 * 2.主要用于打印，检查等
 */
fun testAlso() {
    //origin
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    var reversedLongUppercaseMedals: List<String> =
        medals
            .map { it.uppercase() }
            .filter { it.length > 4 }
            .reversed()
    println(reversedLongUppercaseMedals)

    //also
    println("test also--------------")
    reversedLongUppercaseMedals =
        medals
            .map { it.uppercase() }
            .also { println(it) }
            // [GOLD, SILVER, BRONZE]
            .filter { it.length > 4 }
            .also { println(it) }
            // [SILVER, BRONZE]
            .reversed()
    println(reversedLongUppercaseMedals)
}

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}


/**
 * 不是拓展函数.
 * 1.对象调用多个函数时使用；
 * 2.需要传递对象实例
 */
fun testWith() {
    //origin
    val mainMonitorPrimaryBufferBackedCanvas = Canvas()

    mainMonitorPrimaryBufferBackedCanvas.text(10, 10, "Foo")
    mainMonitorPrimaryBufferBackedCanvas.rect(20, 30, 100, 50)
    mainMonitorPrimaryBufferBackedCanvas.circ(40, 60, 25)
    mainMonitorPrimaryBufferBackedCanvas.text(15, 45, "Hello")
    mainMonitorPrimaryBufferBackedCanvas.rect(70, 80, 150, 100)
    mainMonitorPrimaryBufferBackedCanvas.circ(90, 110, 40)
    mainMonitorPrimaryBufferBackedCanvas.text(35, 55, "World")
    mainMonitorPrimaryBufferBackedCanvas.rect(120, 140, 200, 75)
    mainMonitorPrimaryBufferBackedCanvas.circ(160, 180, 55)
    mainMonitorPrimaryBufferBackedCanvas.text(50, 70, "Kotlin")

    println("test with----------------")
    val mainMonitorSecondaryBufferBackedCanvas = Canvas()
    with(mainMonitorSecondaryBufferBackedCanvas) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }
}