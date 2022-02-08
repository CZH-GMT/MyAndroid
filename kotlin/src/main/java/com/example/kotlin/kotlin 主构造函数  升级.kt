package com.example.kotlin

// TODO kotlin主构造函数升级  在主构造函数里面定义  可变
class KtBase1(var name: String, var age: Int, var sex: Char) {

    fun show() {
        println("name: $name age: $age sex:$sex")
    }

}

fun main() {
    val ktBase1 = KtBase1(name = "哈啥哈哈", age = 18, sex = '男')
    ktBase1.show()

}