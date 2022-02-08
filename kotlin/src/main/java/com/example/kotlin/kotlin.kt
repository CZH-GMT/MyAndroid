package com.example.kotlin

//TODO  异常处理与自定义异常
fun main() {
    var name: String? = null
    try {
        checkException(name)
    } catch (e: Exception) {
        print("哎呀$e")
    }
}

fun checkException(name: String?) {
    name ?: throw eception()
}

class eception : IllegalArgumentException("代码有问题")
