package com.example.kotlinlearn.basetype

import android.util.Log

fun main() {
    var baseType: BaseType = BaseType()
    baseType.testArray()
//    baseType.testList()
//    baseType.testSet()
//    baseType.testMap()
}

class BaseType {
    val one = 1;  //带符号型
    var uintValue: UInt = 1u  //无符号型
    val b: UByte = 1u;


    fun testArray() {
        //sampleStart
        var array = arrayOf("Nile", "Amazon", "Yangtze")

        // 使用 += 赋值操作创建了一个新的 riversArray，
        // 复制了原始元素并添加了“Mississippi”
        array += "Mississippi"
        println(array.joinToString())
        // Nile, Amazon, Yangtze, Mississippi

        println("print by index ----------")
        for (i in array.indices) {
            println(array[i])
        }

        println("print index, content---------")
        for ((index, value) in array.withIndex()) {
            println("index: $index, value: $value")
//            Log.d("BaseType", "index: $index, value: $value")
        }

        println("array-----------")

        //1.使用arrayOf创建数组，必须指定数组的元素，可以是任意类型
        val arrayNumber = arrayOf(1, 2, 3, 4)

        //创建一个指定大小丶所有元素都为空的数组。但必须指定集合中的元素类型
        val arrayOfNulls = arrayOfNulls<String>(5)
        arrayOfNulls[0] = "first"
        arrayOfNulls[1] = "second"
        arrayOfNulls[4] = null
        println(arrayOfNulls)
        for ((index, value) in arrayOfNulls.withIndex()) {
            println("index: $index, value: $value")
//            Log.d("BaseType", "index: $index, value: $value")
        }

        println("bytes----")
        val bytes = ByteArray(5)
        bytes[0]=0x00
        bytes[1]=0x1
        bytes[2]=0x21
        bytes[3]=0x31
        bytes[4]=0x41
        for ((index, value) in bytes.withIndex()) {
            println("index: $index, value: $value")
//            Log.d("BaseType", "index: $index, value: $value")
        }

        println("IntArray---------")
        //创建一个长度为5的空的IntArray
        val intArray2=IntArray(5)
        intArray2[1]=1

        //创建一个长度为5的值全为100的IntArray
        val intArray3=IntArray(5){100}

        //注意这里it是他的索引下标值，所以这是一个创建长度为5的IntArray：0，2，4，6，8
        val intArray4=IntArray(5){it*2}//it,lambad表达式专有变量，这里指的是数组的下标

    }

    fun testList() {
        println("testList ---------")
        //sampleStart
        var riversArray = listOf("Nile", "Amazon", "Yangtze")
        println(riversArray)
        println("print by join---")
        println(riversArray.joinToString())
        // Nile, Amazon, Yangtze, Mississippi

        var shapes: MutableList<String> = mutableListOf("triangle", "square")
        shapes.add("circle")
        println(shapes)

        shapes.remove("square")
        println(shapes)

    }

    fun testSet() {
        val readOnlyFruit = setOf("apple", "banana", "orange", "cherry", "cherry")
        println(readOnlyFruit)
        val fruit = mutableSetOf("apple", "banana", "orange", "cherry", "cherry")
        println(fruit)
    }


    fun testMap() {
        var map = mapOf("apple" to 100, "origin" to 20)
        println(map)
        val pair = mapOf(Pair("apple", 1))
        println(pair)
        //read map
        println("index: " + map["apple"])
        //descrpted
//        println("get: " + map.get("apple"))
        println("getValue: " + map.getValue("apple"))
        println("getOrElse: " + map.getOrElse("apple1") { "origin" })
        println("getOrDefault: " + map.getOrDefault("apple1", 1))
        //遍历
        println("forEach---------")
        map.forEach {
            println("key=${it.key}, value=${it.value}")
        }
        map.forEach { (key, value) ->
            println("$key, $value")
        }

        val strMap = mapOf("apple" to "a", "origin" to "o")
        println(strMap)

        val mutableMap = mutableMapOf("apple" to 100, "origin" to 20)
        mutableMap.put("banana", 3)
        mutableMap["apple"] = 10
        //没获取到key，就往里面放一个
        println(mutableMap.getOrPut("apple1") { 5 })
        println(mutableMap)

        println("has apple ? " + mutableMap.contains("apple"))
    }
}