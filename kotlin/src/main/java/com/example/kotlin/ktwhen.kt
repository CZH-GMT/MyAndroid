package com.example.kotlin

//TODO--------kotlin   when语言表达式
fun main() {
    val week = 8
   val info=when (week) {
        1 -> "今天是周一"
        2 -> "今天是周2"
        3 -> "今天是周3"
        4 -> "今天是周4"
        5 -> "今天是周5"
        6 -> "今天是周6"
        7 -> "今天是周7"
       else -> "啥都没有"
   }
    print(info)


}