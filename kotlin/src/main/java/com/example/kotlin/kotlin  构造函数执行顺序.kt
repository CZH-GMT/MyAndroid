package com.example.kotlin

//TODO kotlin  构造函数执行顺序  调用此函数构造先走主函数构造
//TODO 第一步 生成val age:Int
class KtBase6(name: String, val age: Int) {

    //定义成员
    //TODO 第二步生成val names=name  由于写在init代码块前面所以先生成你  其实《生成成员 和 init代码块是同时生成的》
    val names = name

    //初始化  可监听主构造函数
    init {
        //TODO 第三步 生成nameValue细节
        val nameValue = name
        println("init代码块打印 nameValue:$nameValue")
    }

    //次构造函数
    constructor(name: String, age: Int, sex: Char) : this(name, age) {
        //TODO 第五步 生成次构造细节
        println("次构造函数打印：name:$name age:$age sex:$sex")

    }

    //TODO 第四步
    val hG = "AAA"


}

fun main() {
    //调用次函数构造
    KtBase6("华哥", 18, '男')


}