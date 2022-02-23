package com.example.kotlin

//TODO kotlin 语言的泛型扩展
/*
  String类型输出长度
  显示调用时间
  显示调用者类型
 */
//  String类型输出长度
fun <T> T.showLength() = println(if (this is String) "输入的长度为$length" else "你不是String")

//显示调用时间
fun <T> T.showTime() = println("$this --调用的时间为${System.currentTimeMillis()}")

//显示调用者类型
fun <T> T.showType() =
        when (this) {
            is String -> println("传入的是String")
            is Boolean -> println("传入的是Boolean")
            is Char -> println("传入的是Char")
            is Int -> println("传入的是Int")
            is Float -> println("传入的是Float")
            else -> println("你传入的是其他类型")
        }

fun main() {
    "dsdsdsd".showLength()
    4324343.showLength()

    433242342.showTime()
    "324343".showTime()

    32323.showType()
    ":ewewwew".showType()
    true.showType()
    432.3.showType()
    'c'.showType()
    "mkm434343434k${isok("dsd")}".showType()



}