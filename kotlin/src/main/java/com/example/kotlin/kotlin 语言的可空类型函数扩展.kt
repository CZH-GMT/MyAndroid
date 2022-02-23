package com.example.kotlin

//TODO 语言的可空函数的扩展
//如果是null就输出默认值

//可空函数扩展
fun String?.outputString() = println(this?:"我是null ")
fun String?.outputString1(str:String) = println(if (this == null) str else this)

fun main() {
    var name: String? = null  //name可空可不空
    //  name?.outputString()  //因为我们是做可空函数扩展，在给name添加？  那么可空扩展函数没有起到作用
    val hahhah = "华哥最帅"

    name.outputString()
    hahhah.outputString()

    name.outputString1("我是空的吗")
    hahhah.outputString1("我是空的吗")

}