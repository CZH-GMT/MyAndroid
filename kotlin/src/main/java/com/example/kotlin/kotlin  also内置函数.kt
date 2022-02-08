package com.example.kotlin
//TODO  kotlin also内置函数
fun main() {
    val name:String="hhhhhhhhhhhh"

    name.also {
        "hhh"    //TODO 没有用 只返回本身
        true
        'h'
    }



    name.also {
        print("长度为${name.length}")
    }.also {
        print("转换为大写${name.toUpperCase()}")
    }

}