package com.example.kotlin
//TODO   字符串数字转换成int类型
fun main() {
    val name="555"
    val toInt: Int = name.toInt()
    print(toInt)

    val str="33.3"
    //double类型无法转换成int类型会崩溃
//    val toInt1: Int = str.toInt()
//    print(toInt1)

    //解决崩溃问题  转换失败返回null 不会崩溃
    val sss:Int? = str.toIntOrNull()
    print(sss)//null


    val toIntOrNull = "333".toIntOrNull()
    print(toIntOrNull)//333

    val toIntOrNull1 = "33.333".toIntOrNull()
    print(toIntOrNull1?:"原来你为空呀！！")//原来你为空呀！！


    //TODO  字符串有相关整数的转换减量使用  toIntOrNull()
}