package com.example.kotlin
//TODO kotlin语言的  talkUnless内置函数
/**
 * takeIf和takeUnless功能是相反的
 * name.takeIf{ true/false } true:返回name本身，false:返回null
 * name.talkUnless{ true/false } true: 返回null false:返回name本身
 */
//为什么有takeUnless的出现      takeIf不够吗？？
fun main() {
print(takeUnless("chenzhihua"))

}

fun takeUnless(name: String):String? {
   return name.takeUnless{ isok(name) }?:"jjjjjjjjjjj"
}

fun isok(names: String):Boolean {
   return if (names == "chenzhihua") true else false
}