package com.example.kotlin

//TODO kotlin 构造初始化顺序
class KtBase5(name: String, val age: Int) {

    init {

    }
//
    constructor(name: String, age: Int, sex: String) : this(name, age) {


    }

}

fun main() {

}