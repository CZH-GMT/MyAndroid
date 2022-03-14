package com.example.kotlin.zhujie

//TODO kotlin 注解：jvmoverloads  原理编译器中专门重载一个函数，专门给java使用  若只要函数中参数有默认值 kotlin就可以不用传入   在java中，就需要全部传入，@jvmoverloads可以达到和kotlin一样的效果
@JvmOverloads
fun show(name: String, age: Int = 9, sex: Char = '男') {
    println("name$name,age$age,sex$sex")

}

fun main() {
    //TODO 在kotlin中调用函数  只要函数中参数有默认值 就可以不用传入   在java中，就需要全部传入
    show("kotlin名字")

}