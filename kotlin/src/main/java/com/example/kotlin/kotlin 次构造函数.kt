package com.example.kotlin

//TODO 次构造函数  (constructor 构造)
class KtBase2(name: String) {
    //TODO 次构造函数必须调用主构造函数   因为主构造方便统一管理  为了更好的初始化
    //TODO   先走主构造函数   再走次构造函数
    constructor(name: String, age: Int) : this(name) {
        println("两个参数次构造函数 name：$name age：$age")
    }

    constructor(name: String, age: Int, sex: Char) : this(name) {
        println("三个参数次构造函数 name：$name age：$age sex：$sex")
    }

    constructor(name: String, age: Int, sex: Char, study: String) : this(name) {
        println("四个参数次构造函数 name：$name age：$age sex：$sex study：$study")
    }
}

fun main() {
    KtBase2("华哥", 3)
    KtBase2("华哥", 3, '男')
    KtBase2("华哥", 3, '男', "清华大学")


}