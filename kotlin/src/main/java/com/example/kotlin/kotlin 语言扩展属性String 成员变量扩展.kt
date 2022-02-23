package com.example.kotlin

//TODO kotlin 语言扩展String扩展  成员变量扩展

//TODO  String扩展  后面调用获取的都是derry
val String.showStr: String
    get() = "derry"


//String扩展  打印输出输入内容 然后链式调用(只有String有资格)
fun String.showPrintln(): String {
    println("打印输出输入内容$this")
    return this

}

//TODO 成员变量扩展
val String.showtimes
    get()= "你输入的是$this 输入的时间${System.currentTimeMillis()}"

fun main() {
    val hh = "dsdsdsdsd"
    val showStr = hh.showStr
    println(showStr)

//val ddd ="ds"

    //String扩展  打印输出输入内容 然后链式调用(只有String有资格)
    "ewewew".showPrintln().showPrintln()



println()

    "323".showtimes.showPrintln().showPrintln()
}