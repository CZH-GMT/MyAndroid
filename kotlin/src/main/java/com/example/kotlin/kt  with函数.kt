package com.example.kotlin

//TODO  kotlin  with  函数-->this       具名  with(str：：函数)            with(str){  实现 }
fun main() {
    val name = "Hello Word !"

    val with = with(name, ::method6)
    val with1 = with(with, ::method7)
    val with2=with(with1, ::method8)

    with(name){
        //TODO  this

        print(length)
    }


}

fun method6(str: String) = str.length
fun method7(length: Int) = "字符串的长度为$length"
fun method8(strs: String) = print(strs)