package com.example.kotlin

import java.io.File

//TODO kotlin 超类上定义扩展函数  名字是自己定义随便都可以  定义之后以后任何地方都可以使用这个功能  定义的不能同名  若重写超类里面的方法会覆盖

//超类上定义一个扩展函数    TODO  定义之后以后任何地方都可以使用这个功能
//定义一次
fun Any.showPrintlnContent() = println("当前内容是：$this")

//链式调用  超nb
fun Any.huagfe(): Any {
    println("当前内容是：$this")

    return this
}

data class hahaha(var name: String, var age: Int)


fun main() {
    99999999999.showPrintlnContent()
    44.44.showPrintlnContent()
    "dsdsdsd".showPrintlnContent()
    'n'.showPrintlnContent()

    hahaha("超类上定义扩展函数的实现", 8888888).showPrintlnContent()

    "ghklk".huagfe().huagfe().huagfe().huagfe()

    println(File("C:\\Users\\chenciling\\Desktop\\笔记.txt").readLines())
}