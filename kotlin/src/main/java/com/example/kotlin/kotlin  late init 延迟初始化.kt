package com.example.kotlin

//TODO kotlin lateInit 延迟初始化    必须先调用赋值在调用输出  手动赋值 非常不方便     后面学by lazy{}

class KtBase7() {
    //因为使用了lateInit 所以可以新定义成员
    lateinit var name: String

    //给name赋值
    fun result() {
        name = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
    }

    fun show() {
        println(name)
    }

}

fun main() {
    val ktBase7 = KtBase7()
    //TODO  必须先调用赋值  负责报错
    ktBase7.result()
    //TODO 在调用调用输出 负责报错
    ktBase7.show()

}