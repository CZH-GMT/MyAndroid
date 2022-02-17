package com.example.kotlin

//TODO kotlin 扩展函数

class KtBase35(var name: String, var age: Int, var study: String)

//当KtBase.xxx的时候  this代表着KtBase    不能写私有，写了私有别的地方调用不到
fun KtBase35.show() = println("我是show函数 name$name ,age$age,study$study")//"我是show函数 name$name ,age$age,study$study"

fun KtBase35.getInfo() = println("我是info函数 name$name ,age$age,study$study")

fun String.showStr() = println(this)
fun main() {
    val ktBase35 = KtBase35("ffffff", 22222, "222222222222222222222222222222222222222")
    ktBase35.show()
    ktBase35.getInfo()

    "华哥nb".showStr()

}