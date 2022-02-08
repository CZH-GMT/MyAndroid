package com.example.kotlin

//TODO  字符串遍历  forEach
fun main() {
    val name = "ASDFGHJKL"
    name.forEach { c ->//覆盖掉it  现在c代表每一个元素
        //it代表每一个元素
//        print("所有的字符为$it")
        print("所有的字符为$c")
    }

}