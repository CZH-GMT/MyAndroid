package com.example.kotlin

class KtBase10() {
    val info: String

    init {
        info = "huage"//TODO  写在使用之前
        getinfothring()

    }

    fun getinfothring() {
        println("infothring${info[0]}")

    }
}

fun main() {
    val ktBase10 = KtBase10()
    ktBase10.getinfothring()
}