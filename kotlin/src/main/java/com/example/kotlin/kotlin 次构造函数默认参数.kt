package com.example.kotlin

//TODO 次构造函数  (constructor 构造)
class KtBase3(name: String = "huage") {
    //TODO 次构造函数必须调用主构造函数   因为主构造方便统一管理  为了更好的初始化
    //TODO   先走主构造函数   再走次构造函数
    constructor(name: String = "huage", age: Int = 99) : this(name) {
        println("两个参数次构造函数 name：$name age：$age")
    }

    //TODO 次构造函数必须调用主构造函数
    constructor(name: String = "huage", age: Int = 99, sex: Char = '男') : this(name) {
        println("三个参数次构造函数 name：$name age：$age sex：$sex")
    }

    //TODO 次构造函数必须调用主构造函数
    constructor(name: String = "hauge", age: Int = 66, sex: Char = '女', study: String = "北京大学") : this(name) {
        println("四个参数次构造函数 name：$name age：$age sex：$sex study：$study")
    }
}

fun main() {
    KtBase3("华哥", 3)
    KtBase3("华哥", 3, '男')
    KtBase3("华哥", 3, '男', "清华大学")
    KtBase3() //TODO默认先走主构造函数

}