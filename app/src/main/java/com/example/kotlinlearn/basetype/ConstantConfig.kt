package com.example.kotlinlearn.basetype

/**
 * instead of static final constant value
 * 1.静态方法和属性：companion object 允许你在不创建类的实例的情况下，通过类名直接访问这些方法和属性。
 * 2.实现接口：与普通对象一样，companion object 可以实现接口。
 * 3.工厂方法和单例：常用于创建工厂方法或实现单例模式。
 */
class ConstantConfig {
    //用于在类内部创建静态成员
    companion object {
        const val HANDLE_TIMEOUT = 1000;
        fun getNameValue() = "20"
    }
}