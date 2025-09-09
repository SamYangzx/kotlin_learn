package com.example.kotlinlearn.basetype

class VarargClass {

}

fun a(vararg args: Any) {
    println("a.size = ${args.size}")
    b(args)
    //，所以函数a中的args肯定是空的，注意，它只是size为0，args对象并不为null，args其实是一个数组，对应Java的类型为：Object[]，把此对象传给b函数时，是把Object[]当成一个元素传进去了，这个元素保存在b函数的args数组的args[0]位置，所以b函数的args的size为1，我们希望是把函数a中args数组里面的元素赋值给函数b，而不是把args整体当成一个元素赋值给函数b，
    //
    //原文链接：https://blog.csdn.net/android_cai_niao/article/details/108659795
    b(*args)
}

fun b(vararg args: Any) {
    println("b.size = ${args.size}")
}


fun main() {
    a()
}