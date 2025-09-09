package com.example.kotlinlearn.advance.class_interface

import kotlin.reflect.KProperty

/**
 * 委托属性
 */
class DelegateProperty(val firstName: String, val lastName: String) {
    var displayName: String by CachedStringDelegate()
    var s: String by CachedStringDelegate()
}

class CachedStringDelegate {
    var cachedValue: String? = null

    //    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
    operator fun getValue(thisRef: DelegateProperty, property: KProperty<*>): String {
//        return "$thisRef, 这里委托了 ${property.name} 属性"
        if (cachedValue == null) {
//            cachedValue = "Default Value"
            cachedValue = "${thisRef.firstName} ${thisRef.lastName}"
            println("Computed and cached: $cachedValue")
        } else {
            println("Accessed from cache: $cachedValue")
        }
        return cachedValue ?: "Unknown"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }

}

fun main() {
    val user = DelegateProperty("Sam", "Yang")
    // 第 1 次访问属性时, 计算值, 并缓存
    println(user.displayName)
    // 输出结果为: Computed and cached: John Doe
    // 输出结果为: John Doe

    // 后续访问属性时, 会从缓存获取值
    println(user.displayName)
    // 输出结果为: Accessed from cache: John Doe
    // 输出结果为: John Doe
}