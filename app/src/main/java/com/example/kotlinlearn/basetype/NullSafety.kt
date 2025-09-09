package com.example.kotlinlearn.basetype

/**
 * 处理空值
 */
class NullSafety {}

fun main() {
    var neverNull: String = "never null"
    // Throws a compiler error
//    neverNull =null
    var nullable: String? = "can be null"
    nullable = null


    // notNull doesn't accept null values
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    println(strLength(neverNull)) // 18
//    println(strLength(nullable))  // Throws a compiler error

    val nullString: String? = null
    println(describeString(nullString))


    println(lengthString(nullString))

    println(nullString?.length ?: 0)  //will print default value 0
    // 0


    testAs()
}

fun describeString(maybeString: String?): String {
    if (!maybeString.isNullOrEmpty()) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}


fun lengthString(maybeString: String?): Int? = maybeString?.length

fun testAs() {
    val a: String? = null
//    val b = a as String  //a 是null, 这里会发生运行期错误
    val b = a as? String  //a 是null, 用as? 不会报错
    print(b)
}
