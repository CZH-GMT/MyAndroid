package com.example.kotlin

fun main() {
    //TODO 检测函数为空
    var name: String? =null
    //还可以检测false

    var isok:Boolean=false
    require(isok)//检测false抛出异常
    //检测空值
    requireNotNull(name)
    checkNotNull(name)




}