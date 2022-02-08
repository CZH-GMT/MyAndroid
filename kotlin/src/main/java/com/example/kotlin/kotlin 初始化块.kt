package com.example.kotlin

//TODO  kotlin       初始化块init{}1. 以调用主构造函数中的临时参数 2.可以监听主构造函数的调用
/*
    1.name,age,sex主构造函数
    2.init代码块学习 require()boolean 类型
    3.临时类型只能在init代码块内才能调用
 */
//TODO 主构造参数临时类型  必须二次转换  ------>但是在init初始化块中可以使用
class KtBase4(name: String, age: Int) {
    //TODO 监听主构造函数
    //TODO  初始化块 init代码块
    init {
        println("主构造函数被调用$name , $age")

        require(age > 0) { "年龄异常小于0" }
        require(name.isNotBlank()) { "名字为空" } }

    constructor(sex: String) : this("g", 1) {
        println("次构造函数被调用")

    }

}

fun main() {
    KtBase4("hahah", 10)//调用主构造函数
    println("---------------------------------->")
    KtBase4("🚹")
}