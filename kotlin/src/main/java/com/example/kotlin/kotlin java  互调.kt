package com.example.kotlin

//TODO kotlin java 互调

fun main() {
    //错误
    println(javakotlinjiaohu().age)
    println(javakotlinjiaohu().name.length)

    println()
    //一般接收只要有java 就要 接收加？  判空
    val age: Int? = javakotlinjiaohu().age
    val length: Int? = javakotlinjiaohu().name.length

    println(age)
    println(length)
}