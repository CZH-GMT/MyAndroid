package com.example.kotlin

//TODO kotlin in逆变  out 协变的使用

//当我们对整个类里面的泛型只能修改不能读取的时候使用in
class KtBase31<in T>() {


    fun set1(item: T) {
        println("你修改后的T：$item")

    }
}

//当我们整个类的泛型只允许外界读取的时候用out
class KtBase32<out T>(item: T) {
    val items: T = item    //必须使用val 因为不能被修改
    fun get1(): T? {
        return items
    }
}

fun main() {
    val ktBase31 = KtBase31<String>()
    println(ktBase31.set1("hahhahah"))

    val ktBase32 = KtBase32("王五")
    println(ktBase32.get1())
}